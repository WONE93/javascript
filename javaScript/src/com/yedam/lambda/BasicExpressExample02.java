package com.yedam.lambda;

interface MyInterfaceReturn {
	int getResult(int a, int b);
}

public class BasicExpressExample02 {
	public static void main(String[] args) {
		MyInterfaceReturn mir = new MyInterfaceReturn() {

			@Override
			public int getResult(int a, int b) {
				//way1
				return a+b; // 재정의해야함
			}		
		};				
		int result = mir.getResult(10, 20);
		System.out.println("결과는 " +result);
		
		//way2
		mir = (num1, num2) -> {
			return num1 * num2;
		};
		result = mir.getResult(5, 20);		
		System.out.println("결과는 " +result);
		
				
	} // End of Main

}// End of Class
