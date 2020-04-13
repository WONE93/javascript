package com.yedam.io;

import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("문자열 입력> ");
		String name = scn.nextLine();
		System.out.println(name);
		
		System.out.print("정수 입력> ");
		int num = scn.nextInt();
		System.out.println(num);
		
		System.out.print("실수 입력> ");
		double inputDouble = scn.nextDouble();
		System.out.println(inputDouble);
		
		
	}
}
