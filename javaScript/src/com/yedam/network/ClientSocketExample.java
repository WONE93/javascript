package com.yedam.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientSocketExample {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			System.out.println("[연결요청]");
			socket = new Socket();
			socket.connect(new InetSocketAddress("192.168.0.50", 5001));
			System.out.println("[연결성공]");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] buf = null;
		String message = null;
		
		try {
			OutputStream os = socket.getOutputStream();
			message = "Hello 지원";
			buf = message.getBytes("utf-8");
			os.write(buf);
			os.flush();
			System.out.println("[보내기 성공]");
			
			InputStream is = socket.getInputStream();
			buf = new byte[100];
			int readByte = is.read(buf);
			message = new String(buf, 0, readByte, "utf-8");
			
			System.out.println("[데이터 받기 성공]" + message);
			
			is.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
