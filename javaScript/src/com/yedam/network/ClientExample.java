package com.yedam.network;

//오늘은 클라이언트까지
//서버가 시작되면 클라이언트 요청이 들어오면 접속을 받아서 소켓을 만들고 각 클라이언트마다 서버를 보내는 기능 만들 예정
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientExample extends Application {
	Socket socket;

	// 매소드 정의
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}

	// startClient()
	void startClient() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				socket = new Socket();
				try {
					socket.connect(new InetSocketAddress("192.168.0.69", 5001));
					Platform.runLater(() -> {
						displayText("[연결 완료: " + socket.getRemoteSocketAddress() + "]");
						btnConn.setText("stop");
						btnSend.setDisable(false);
					});
				} catch (IOException e) {
					e.printStackTrace();
					// 연결 시도했는데 연결 안되면 소켓만들었던거 다 클로즈할거임
					Platform.runLater(() -> displayText("[서버 통신 안됨]"));
					if (!socket.isClosed()) {
						// 밑에있는 스탑매소드 호출할거임
						stopClient();
					}
				}
			}

		};
		thread.start();
	}

	// stopClient()
	void stopClient() {
		Platform.runLater(() -> {
			displayText("[연결 끊음]");
			btnConn.setText("start");
			btnSend.setDisable(true);
			if (socket != null && !socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	// receive()
	void receive() {
		// 리시브는 언제 받을지 모르기 때문에 항상 열어둬야함
		while (true) {
				
			try {
				byte[] buf = new byte[100];
				InputStream is = socket.getInputStream();
				int readByte = is.read(buf);
				if (readByte == -1) {
					throw new IOException(); // -1값을 받아서 예외처리로 던져버리기
				}
				// 정상적으로 읽어왔으면 데이타라는 변수에다가 담겟다
				String data = new String(buf, 0, readByte, "UTF-8");
				Platform.runLater(() -> {
					displayText("[받기 완료]" + data);
					stopClient();
				});
			} catch (IOException e) {
				e.printStackTrace();
				Platform.runLater(() -> {
					displayText("[서버 통신 안됨]");
				});
				stopClient();
				break; // while 구문을 빠져나오겠다
			} // end of try catch
		} // end of while
	}// end of receive()

	// send()
	void send(String data) {
		Thread thread = new Thread() {
//			String userDate = "[won]";
			@Override
			public void run() {
				try {
					byte[] buf = data.getBytes("UTF-8");
					OutputStream os = socket.getOutputStream();
					os.write(buf);
					os.flush();
					Platform.runLater(() -> {
						displayText("[보내기 완료]");
					});
				} catch (IOException e) {
					e.printStackTrace();
					Platform.runLater(() -> {
						displayText("[서버 통신 안됨]");
						stopClient();
					});
				}
			}

		};
		thread.start();
	}

	// start() => UI 만드는 메소드.
	TextArea txtDisplay;
	TextField txtInput;
	Button btnConn, btnSend;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);

		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
		root.setCenter(txtDisplay);

		BorderPane bottom = new BorderPane();
		txtInput = new TextField();
		txtInput.setPrefSize(60, 30);
		BorderPane.setMargin(txtDisplay, new Insets(0, 1, 1, 1));

		btnConn = new Button("start");
		btnConn.setPrefSize(60, 30);
		btnConn.setOnAction(event -> {
			if (btnConn.getText().equals("start")) {
				 startClient(); // 매소드를 호출할 예정
			} else if (btnConn.getText().contentEquals("stop")) {
				 stopClient();
			}
		});

		btnSend = new Button("send");
		btnSend.setPrefSize(60, 30);
		btnSend.setDisable(true);
		btnSend.setOnAction(event -> 
			send("[지원장님]" +txtInput.getText()) ); // "메세지 보내는 기능" 이벤트는 파라매터값
		
		bottom.setCenter(txtInput);
		bottom.setLeft(btnConn);
		bottom.setRight(btnSend);

		root.setBottom(bottom);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Client");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	} // e of m

} // e of c