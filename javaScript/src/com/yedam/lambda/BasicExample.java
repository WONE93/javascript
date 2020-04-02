package com.yedam.lambda;

import java.awt.Toolkit;

//3way 1.구현클래스  2.익명객체 3.표현식
class RunnableCls implements Runnable {
	Toolkit tkit = Toolkit.getDefaultToolkit();
	
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			tkit.beep();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // e of f

	}

}

public class BasicExample {
	public static void main(String[] args) {
		RunnableCls rcs = new RunnableCls();
		Thread thread = new Thread(rcs);
		thread.start();

		
		for (int i = 0; i < 10; i++) {
			System.out.println("print it.=> " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

//		for (int i = 0; i < 10; i++) {
//			System.out.println("print it.=> " + i);
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}
}
