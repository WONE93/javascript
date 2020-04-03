package com.yedam.lambda;

import java.util.function.BiConsumer;

class Students {
	String name;
	int age;

	public Students(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void getInfo() {
		System.out.println("이름: " + this.name + ", 나이: " + this.age);
	}
}

public class CounsumerExample {
	public static void main(String[] args) {
		BiConsumer<Students, String> biCon = (std, str) -> {
			System.out.println(str + " ");
			std.getInfo(); // 안녕하세요 이름:?? 나이: ??
		};
//		Students s1 = new Students("Seo ", 18);
//		String s2 = "안녕.";
//		biCon.accept(s1, s2); // 어셉트는 리턴타입 없다
//		printAccept(biCon, s1, s2);
		
		//두개 다 스트링 타임으로
		Students s2 = new Students("Seong ", 17);
		String s3 = "안뇨오올.";
		biCon.accept(s2, s3); 
		
		BiConsumer<String, String> biStr = (str1,str2) -> {
			System.out.println(str1 +" "+ str2);
		};
		biStr.accept("람다는", "헷갈려!!");
	}
	
	// 인터페이스가 매개값으로 들어 갈 수도 있다.
	static <T, U> void printAccept(BiConsumer<Students, String> biCon, 
									Students std, 
									String str) {
		
		biCon = (s1, s2) -> {
			System.out.println(s2 + " ");
			s1.getInfo();
		};
		biCon.accept(new Students("Kim", 33), "ㅇ앙녕");

	} // e of m
}// e of c
