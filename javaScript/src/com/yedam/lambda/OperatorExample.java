package com.yedam.lambda;

import java.util.function.IntBinaryOperator;
class IntBinaryClass implements IntBinaryOperator {
	@Override
	public int applyAsInt(int left, int right) {
		if(left>=right) {
			return left;
		}else {
			return right;
		}
	}	
}// e of c  큰놈을 리턴해주는 클레스 생성
 //구현클래스
public class OperatorExample {
	static int[] scores = { 92, 95, 87};
	
	public static int maxOrMin(IntBinaryOperator oper) {
	    int result = scores[0];
	    for(Integer score : scores) {
	    	result = oper.applyAsInt(result, score);
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		IntBinaryClass iclass = new IntBinaryClass();
		int result = maxOrMin(iclass);
		System.out.println("결과: " +result);
	}// e of main

} // e of C
