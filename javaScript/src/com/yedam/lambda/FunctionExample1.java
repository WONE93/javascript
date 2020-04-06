package com.yedam.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExample1 {
	private static List<Student> list = Arrays.asList(new Student("홍길동", 90, 96), new Student("신용권", 95, 93));

	public static void printString(Function<Student, String> Function) {
		for (Student student : list) {
			System.out.println(Function.apply(student) + " ");
		}
		System.out.println();
	}

	public static void printInt(ToIntFunction<Student> function) {
		for (Student student : list) {
			System.out.println(function.applyAsInt(student) + " ");
		}
		System.out.println();
	}

	// 평균구하는 매소드
	public static double avg(ToIntFunction<Student> func) {
		double avg;
		int sum = 0;
		for (Student student : list) {
			sum += func.applyAsInt(student);
		}
		avg = (double) sum / list.size();
		return avg;
	}

	public static void main(String[] args) {
		System.out.println("[학생이름]");
		printString(t -> t.getName());

		System.out.println("[영어점수]");
		printInt(t -> t.getEnglishScore());

		System.out.println("[수학점수]");
		printInt(t -> t.getMathScore());

		// 람다식으로 표현
		double avg = avg(s -> s.getEnglishScore());
		System.out.println("영어평균: " + avg);

		// 람다식1
//		double avg1 = avg( s -> s.getMathScore());
//		System.out.println("수학평균: " + avg1);

		// 익명객체1
		avg = avg(new ToIntFunction<Student>() {
			@Override
			public int applyAsInt(Student s) {
				return s.getMathScore();
			}
		}); // tofuction을 구현하는 익명객체
		System.out.println("수학" + avg);

	}// e of m
}// e of c

// ToIntFunction<Student>를 구현하는 MathIntClass 정의..
class MathIntClass implements ToIntFunction<Student>{

	@Override
	public int applyAsInt(Student s) {
		return s.getMathScore();
	}
}
