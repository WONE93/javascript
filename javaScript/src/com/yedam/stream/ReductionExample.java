package com.yedam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class ReductionExample {
	public static void main(String[] args) {
		
		List<Student> list = Arrays.asList(new Student("Hong", 92),
					  new Student("Hwang", 95),
					  new Student("Park", 88));	
		
		int sum = list.stream().mapToInt(s->s.getScore()).sum();
		
		// Way1 :  Student.getScore(int) reduce()
		OptionalInt oi = list.stream()
						.mapToInt(s->s.getScore())
						.reduce((a,b) -> a+b);
		if(oi.isPresent()) {
			System.out.println(oi.getAsInt());
		}
		
		// * Way2 reduce 라는 집계를 만드는 메소드로 값을 가져오는 방식
		// Student.getScore(int) reduce(0, 결과값) 초기값설정으로 값이 없을경우 초기값으로 리턴하게 설정
		int result = list.stream()
					.mapToInt(s->s.getScore())
					.reduce(0, (a,b) -> a+b); //값이 없을경우는 리턴값이 인트타입
		System.out.println(result);
		
	}
}
