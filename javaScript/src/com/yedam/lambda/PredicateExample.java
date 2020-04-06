package com.yedam.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
	static List<Student> list = Arrays.asList(
				new Student("홍길동","남자",90,80)
				,new Student("김순희","여자",90,85)
				,new Student("김자바","남자",95,85)
				,new Student("박한나","여자",92,85)
				
			);
	
	static double avg(Predicate<Student> pred) {
		int sum = 0, cnt=0;
		for(Student student : list) {
			if(pred.test(student)) { // return 타입: boolean 
				sum += student.getEnglishScore();
				cnt++;
			} else {
			
			}
		}
		return (double) sum / cnt;
		 
	}
	
	public static void main(String[] args) {
		double result = avg(new Predicate<Student>() {
			@Override
			public boolean test(Student t) {
				return t.getSex().contentEquals("여자");
//				if(t.getSex().contentEquals("남자"))
//					return false;
//				else
//					return false;
			} //인스턴스에 뉴를 붙이는건 괄호안의 익명객체를 받겟다는 뜻
		});
		System.out.println("결과: " +result);
		
		//람다표현식
		 result = avg(t -> t.getSex().contentEquals("남자"));
		 System.out.println("결과: " +result);
				
	}// e of M
} // e of C
