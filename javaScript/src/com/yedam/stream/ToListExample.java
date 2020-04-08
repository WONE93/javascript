package com.yedam.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToListExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
					 new Student("Hong", 10, Student.Gender.MALE),
				 	 new Student("Hwang", 9, Student.Gender.FEMALE),
				 	 new Student("Choi", 8, Student.Gender.MALE),
				 	 new Student("Park", 7, Student.Gender.FEMALE)
		);
		
		// 남학생들만 묶어 List 생성
		List<Student> maleList = list.stream()
								.filter(s->s.getGender()==Student.Gender.MALE)
								.collect(Collectors.toList());
		maleList.stream()
				.forEach(s -> System.out.println(s.getName()));
		
		System.out.println();
		
		//여학생들만 묶어 HashSet 생성
		Set<Student> femaleSet = list.stream()
								.filter(s -> s.getGender() == Student.Gender.FEMALE)
								.collect(Collectors.toCollection(HashSet :: new)); 
		femaleSet.stream()
				.forEach(s -> System.out.println(s.getName()));

		// 점수가 9점 이상인 사람 추출 
		// collect(Collectors.toCollection()) -> HashSet<Student>
		HashSet<Student> scoreSet = list.stream()
								.filter(s -> s.getScore() >= 9)
								.collect(Collectors.toCollection(HashSet :: new)); 
//								.collect(Collectors.toCollection( () -> new HashSet<Student>() )); // 투콜렉션 ()안에 정의된 타입으로 리턴하겠다는 뜻
		scoreSet.stream().forEach(s-> System.out.println(s.getName()));	
		
		
	}
}
