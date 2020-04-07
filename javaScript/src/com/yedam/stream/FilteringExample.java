package com.yedam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FilteringExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동","신용권","김자바","신용권","신민철");
		Stream<String> stream = list.stream();
//		stream.distinct().forEach(s -> System.out.println(s));
		stream.distinct()// 중간처리 (신용권 중복제거)
						.filter(s -> s.startsWith("신")) // 중간처리("신"으로 시작하는사람)
//						.forEach(s -> System.out.println(s));
						
						//익명객체
//						.forEach(new Consumer<String>() {
//							@Override
//							public void accept(String t) {
//								System.out.println(t.toString());								
//							}						
//						});
						// 람다표현식
						.forEach(t ->
								System.out.println(t.toString()));								
											
					
	}
}
