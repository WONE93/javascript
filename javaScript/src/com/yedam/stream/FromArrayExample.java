package com.yedam.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArrayExample {
	public static void main(String[] args) {
		String[] strArr = { "Hong", "Hwang", "Choi" };
		Stream<String> strStream = Arrays.stream(strArr);
		int[] intArr = {3,4,5,6,2};
		IntStream intStream = Arrays.stream(intArr);
		
		strStream.forEach(s -> System.out.println(s));
		intStream.forEach(i -> System.out.println(i)); //배열을통해 스트림을 생성하는방법
		
		IntStream rangeStream = IntStream.range(1, 10);
		System.out.println("=====range========");
		rangeStream.forEach(r -> System.out.print(r + " "));
		
		IntStream rangeStream2= IntStream.rangeClosed(1,10);
		System.out.println();
		System.out.println("========closed=========");
		rangeStream2.forEach(r -> System.out.print(r + " "));
		
		
		
	}
}
