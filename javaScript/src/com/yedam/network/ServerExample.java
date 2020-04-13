package com.yedam.network;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
							//UI만들기위한 애플리케이션 쓰레드를 익스텐드하자
public class ServerExample extends Application{
	ExecutorService executorService; // connection이 연결될때마다 소켓처리
	ServerSocket serverSocket;
	List<Client> list = new Vector<>();

	void startServer() {
		System.out.println("Processor 수: " + Runtime.getRuntime().availableProcessors());
		executorService = Executors.newFixedThreadPool( // 가능한 쓰레드 몇개까지 만들꺼냐 개수를 만드는 것.
				Runtime.getRuntime().availableProcessors());

		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("192.168.0.50", 5001));
		} catch (IOException e) {
			e.printStackTrace();
			// 아이피를 따라갔더니 서버가 없을경우 예외처리
			if (!serverSocket.isClosed())
				stopServer(); //servercoCket을 close하는 stopServer메소드를 따로 정의한다
		}
		//러너블은 인터페이스 so, add 메소드
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				Platform.runLater( ()-> {
					displayText("[서버 시작");//나중에 작업을 하겠다는 의미 // 작업이 정상적으로 진행되면 이걸 화면에 뿌려줌
					btnStartStop.setText("stop");
				}); 
				while(true) {
					try {
						Socket socket = serverSocket.accept();
						String message = "[연결 수락:]" + socket.getRemoteSocketAddress()+ " : " +Thread.currentThread().getName()+ "]";
						Platform.runLater( 
								()->displayText(message) // 익명객체 표현하는걸 람다표현식으로 사용하는 것
										);
						Client client = new Client(socket);
						list.add(client);
					} catch (IOException e) {
						if(!serverSocket.isClosed()) {
							stopServer();
						}
						break;
					}
				} // e of While
					
			}// e of run
			
		}; // e of Runnable
		//기능을 정의하는 것
		executorService.submit(runnable);

	} // e of startServer()

	void displayText(String text) {
		txtDisplay.appendText(text+ "\n");
		
	}

	void stopServer() {
		try {
			Iterator<Client> iterator = list.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close(); //예외처리 해줘야함
				iterator.remove(); //하나씩 지우는 것
			}
			if (serverSocket != null && !serverSocket.isClosed())
				serverSocket.close();
			if (executorService != null && !executorService.isShutdown())
				executorService.shutdown();
			Platform.runLater( ()->{
				displayText("[서버멈춤]");
				btnStartStop.setText("stop");
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end of stopserver()

	class Client {
		Socket socket;   
		Client(Socket socket){
			this.socket = socket;
		}
		void receive() {
			//등록할 작업을 여기다 정의
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
					  while (true) {
						InputStream is = socket.getInputStream();
						byte[] buf = new byte[100];
						int readByte = is.read();
						if(readByte == -1) {
							throw new IOException();//예외를 주겠다는 의미 
						}
						String message = "[요청처리: " +socket.getRemoteSocketAddress()+ " : " +Thread.currentThread().getName()+ "]";
						Platform.runLater( ()->{
							displayText(message);
						});
						String data = new String(buf, 0, readByte, "UTF=8");
						for (Client client : list) {
							client.send(data);
						}
					  }// e of While
					} catch (IOException e) {
						list.remove(Client.this);
						String message = "[클라이언트 통신 안됨: "
								+ socket.getRemoteSocketAddress()
								+ " : "
								+ Thread.currentThread().getName()
								+ " ] ";
						Platform.runLater( ()->{
							displayText(message);
						});
						try {
							socket.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					
					}
				}
		
			};
			executorService.submit(runnable);
		}
		void send(String data) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
						byte[] buf = new byte[100];
						OutputStream os;
						try {
							os = socket.getOutputStream();
							buf = data.getBytes("UTF-8");
							os.write(buf);
							os.flush();
						} catch (IOException e) {
							String message = "[클라이언트 통신 안됨: "
									+Thread.currentThread().getName()
									+":"
									+"]";
							Platform.runLater( ()-> {
								displayText(message);
							});
							list.remove(Client.this);
							try {
								socket.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
				} // end of run
//				executorService.submit(runnable);
			};
			
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	//서버 이그잼플 클래스 전체에서 사용하기 위해 이 위치에 필드로 정의한 것임
	TextArea txtDisplay;
	Button btnStartStop;

	// ui 만드는 start()
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);
		
		txtDisplay = new TextArea();
		txtDisplay.setEditable(false); // 속성에 에딧못하게 설정
		BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
		root.setCenter(txtDisplay);
		
		btnStartStop = new Button("start");
		btnStartStop.setPrefHeight(30);
		btnStartStop.setMaxWidth(Double.MAX_VALUE);
		btnStartStop.setOnAction( (event) -> {
			if(btnStartStop.getText().equals("start"))
				startServer();
			else if(btnStartStop.getText().equals("stop"))
				stopServer();
		});
		
		root.setBottom(btnStartStop);		
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		primaryStage.show(); // show는 나타나게하는 메소드
		
	}
}