package com.yedam.lambda;

@FunctionalInterface // interface의 기능을 체크한다
interface MyInterface1<T> {
	void get(T t); // 펑셔널의 타켓타입
//	void set(); // 구현하는 기능이 한개여야한다
}
@FunctionalInterface 
interface MyInterface2 {
	String get(String str, String str1); 
}
interface Consumer<T> {
	void get(T t);
}

//class ConsumerClass<T> implements Consumer<T> {
//	@Override
//	public void get(T t) {
//		System.out.println();
//	}	
//}

//class MyInterClass implements MyInterface1 {
//	@Override
//	public void get() {
//		System.out.println("Hello");		
//	}	
//}

public class BasicExample2 {
	public static <T> void main(String[] args) {		
//		MyInterface1<Student> mi = (Student s) -> {
//			String r = (String) s;
//			System.out.println("Hello" + s);
//			}; // ()안의 매개값을 받아서 {}안의 내용을 실행하시오
//			mi.get(new Student());
//		
		MyInterface2 mi2 = new MyInterface2() {

			@Override
			public String get(String str, String str1) {
				return str.concat(str1); // str + str1
			}
		};
		String result = mi2.get("Hello " , "world");
		System.out.println(result);
		
		//익명객체
		Consumer<String> con = new Consumer<String>() {
			@Override
			public void get(String t) {
				System.out.println("Consumer");
			}	
		};
		con.get("");
		
		//람다식
		Consumer<String> con2 = (String c) -> {
			System.out.println("Hello" + c);			
		};
		con2.get(" aoaoaoaoao");
	
		
		
// 익명객체
//		MyInterface1 mi = new MyInterface1() {
//			@Override
//			public void get() {
//				System.out.println("Hello");
//			}
//		};

// 클래스로 하는법
//		MyInterface1 mi = new MyInterClass();
//		mi.get();

	}// end of main
}// e of class