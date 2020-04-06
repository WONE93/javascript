package com.yedam.lambda;

import java.util.function.IntBinaryOperator;
//class IntBinaryClass implements IntBinaryOperator {
//	@Override
//	public int applyAsInt(int left, int right) {
//		if(left>=right) {
//			return left;
//		}else {
//			return right;
//		}
//	}	
//}// e of c  큰놈을 리턴해주는 클레스 생성

public class OperatorExample2 {
	static int[] scores = { 92, 95, 87};
	
	public static int maxOrMin(IntBinaryOperator oper) {
	    int result = scores[0];
	    for(Integer score : scores) {
	    	result = oper.applyAsInt(result, score);
	    }
	    return result;
	}
	// 익명객체 구현클래스없이 구현해주는 객체만 있음
	public static void main(String[] args) {
		IntBinaryClass iclass = new IntBinaryClass();
		int result = maxOrMin(iclass);
		
		result = maxOrMin(new IntBinaryOperator() {
			@Override
			public int applyAsInt(int left, int right) {
				if(left>=right) {
					return left;
				}else {
					return right;
				}
			}		
		});
		System.out.println("결과: " +result);
	}// e of main

} // e of C
