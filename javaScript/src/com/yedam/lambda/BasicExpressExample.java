package com.yedam.lambda;

//class RunnableImpl implements Runnable {
//	@Override
//	public void run() {
//		System.out.println("runnable call, ");
//	}
//}  //할때마다 내용이 달라져서 클레스 이름 만드는게 의미가 없음 그래서 할때마다 만들어서 사용하겠다 밑의 방식으로 

interface MyInterface {
	void method(int a);
}

//class MyInterfaceClass implements MyInterface{
//
//	@Override
//	public void method() {
//	}	
//}  //이 클래스는 구현하고자 하는 목적 단한가지

public class BasicExpressExample {
	public static void main(String[] args) {

		MyInterface mi = (num) -> {
			System.out.println("method call. " + num);
		};

		mi.method(10);

		Runnable runnable = new Runnable() { // Runnable은 인스턴스 생성x so, 밑의 방식으로 사용
			@Override
			public void run() { // 러너블은 구현할 매소드가 단 하나. run
				System.out.println("runnable call.");

			}
		}; // 익명 객체를 작성하는 방식

		// 필요없는 객체들을 모두 빼고 입력하는 방식
		runnable.run();

		Runnable runnable1 = () -> {
			System.out.println("runnable lambda call. ");
		};
		runnable1.run();

	} // end of main
} // end of class
