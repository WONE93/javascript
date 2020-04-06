package com.yedam.lambda;

import java.util.function.IntBinaryOperator;

public class OperatorExample3 {
	static int[] scores = { 92, 95, 87};
	
	public static int maxOrMin(IntBinaryOperator oper) {
	    int result = scores[0];
	    for(Integer score : scores) {
	    	result = oper.applyAsInt(result, score);
	    }
	    return result;
	}
	// 람다식
	public static void main(String[] args) {
//		IntBinaryClass iclass = new IntBinaryClass();
//		int result = maxOrMin(iclass);
		
		int result = maxOrMin((int left, int right) -> {
				if(left>=right) {
					return left;
				}else {
					return right;
				}			
		});
		System.out.println("결과: " +result);
	}// e of main

} // e of C
