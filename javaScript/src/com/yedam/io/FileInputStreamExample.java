package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamExample {
	public static void main(String[] args) throws IOException {
		String path = "src/com/yedam/io/input.txt";
		FileInputStream fis = new FileInputStream(path); //생성자
		String outPath = "src/com/yedam/io/output.txt";
		FileOutputStream fos = new FileOutputStream(outPath);
		
////////////////////////	input	
//		int readByte;
//		while((readByte = fis.read()) != -1) {
//			System.out.print((char)readByte);
//		}
////////////////////////
//		while(true) {
//			readByte = fis.read();
//			if(readByte == -1) {
//				break;
//			}
//			System.out.print((char)readByte);
//		}
/////////////////////// output
		int readByte2;
		while((readByte2 = fis.read()) != -1) {
			fos.write(readByte2);
		}
		System.out.print((char)readByte2);
		fos.flush();
		fos.close();
		fis.close();
///////////////////////
		String iPath = "src/com/yedam/io/test.jpg";
		FileInputStream ifis = new FileInputStream(iPath);
		int readByte3;
		long start = System.nanoTime();
		while((readByte3 = ifis.read()) != -1) {
		}
		ifis.close();
		long end = System.nanoTime();
		System.out.println((end - start) + "ns");
		System.out.println("====end====");
		
		FileInputStream ifis2 = new FileInputStream(iPath);
		byte[] buf = new byte[100];
		start = System.nanoTime();
		while((readByte3 = ifis2.read(buf)) != -1) {
			
		}
		ifis2.close();
		end = System.nanoTime();
		System.out.println((end - start) + "ns");
		System.out.println("====end====");
		
	}
}
