package com.yedam.io;

import java.io.FileReader;
import java.io.IOException;

public class ReaderWriterExample {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(
			"src/com/yedam/io/FileExample.java"
		);
		
//		int readCharNo;
//		char[] cbuf = new char[100];
//		while((readCharNo = fr.read(cbuf)) != -1) {
//			String data = new String(cbuf, 0, readCharNo);
//			System.out.println(data);
//		}
//		fr.close();
		
		int readCharNo;
		while((readCharNo = fr.read()) != -1) {
			System.out.print((char) readCharNo);
		}
		fr.close();
		
	}
}
