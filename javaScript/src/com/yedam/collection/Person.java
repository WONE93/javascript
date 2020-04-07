package com.yedam.collection;

public class Person implements Comparable<Person> {
	String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	@Override
	public int compareTo(Person o) { //CompareTo의 반화값은 인트
//		return this.age - o.age; //
		return this.name.compareTo(o.name); // 이름의 가나다순 정렬
		
//		if(this.age > o.age) {
//			return 1;
//		}else if(this.age < o.age){
//			return -1;
//		}else {
//			return 0;
//		}
		
	}
	
}
