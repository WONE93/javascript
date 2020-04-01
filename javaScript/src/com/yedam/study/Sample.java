package com.yedam.study;

import java.util.ArrayList;
import java.util.List;

public class Sample {

	public static int sum(int a, int b) {
		return a + b;
	} // 호출되는 시점에 샘플이 임포트되면 sum이라는 매소드 쓸 수 있게 준비되어짐

	public static int minus(int a, int b) {
		return a - b;
	}

	public static void main(String[] args) {
		StudentService service = new StudentServiceImpl();
		Student st = service.getStudent(101);
		System.out.println("한건조회" + st);
		
		
		
		//<리스트 부분>
		System.out.println("=====List======");
//		StudentService service = new StudentServiceImpl();
		List<Student> list = service.getStudList();
		
		for(Student s : list) {
			System.out.println(s.toString());
		}
		service.getStudList();
		
		
		//인터페이스는 인스턴스 만들지 못해서 IMPL로 생성자를 만들어준다 
		// 인스턴스를 구현하는 thigns들은 Impl로써 구현한다
		//정의로 가면 인터페이스창 실행창 가면 impl클래스로 이동
		//기능이 단점 보완 돼서 업그레이드 돼서 즉 버전2가 되면 기능은 정의가 되어있으면 적용하기 편하다.  
		// 즉 쓰는 방식은 똑같은데 구현하는 클래스만 바꿔주면 기존의 소스들을 안바꿔줘도 되니깐.
		//인터페이스는 큰 틀, 업그레이드 되면 세세부분은 클래스2로 가져와서 쓰면되니깐 편리
	
	
//		EmpDAO dao = new EmpDAO(); //생성자를 호출하겠다는 의미
//		List<Student> list = dao.getEmpList();  
//		for(Student s : list) {  // 겟임플로이리스트(sql)에서 가져온 리스트를 스튜던트 s에 담겠다.
//			System.out.println(s.toString());
		
		
////		int result = sum(3,9);
//////		Sample s = new Sample();  // 매소드도 다 static으로 만들면 인스턴스 안만들어도 기능함
////		int result1 = minus(6,2);
//
//		Person p1 = new Person();
////		p1.name = "Hong";  // person에서 네임을 프라이빗설정해서 밑의 방식으로 정보입력
//		p1.setName("Hong");
//		p1.setAge(10);
//		String n = p1.getName(); // 타입선언해서 호출
////		System.out.println(p1.getName());
//		System.out.println(n);
//		int b = p1.getAge();
//		System.out.println(b);
//		// ========== 위는 매소드를 통해 정보호출
//		Person p2 = new Person("Seo", 20);
//	
//
//		// 스튜던트 클래스
//		System.out.println("===S===");
//		Student s1 = new Student();
//		s1.setName("park");
//		s1.setAge(20);
//		s1.setSchool("yedam");
//		Student s2 = new Student("kim", 20, "yedam");
////		System.out.println(s1.toString());
//		
//		List<Person> list = new ArrayList<>();  
//		list.add(p1);
//		list.add(p2);
//		list.add(s1);
//		list.add(s2);
//		System.out.println("====리스트목록===");
//		System.out.println(list);
//		if(list.remove(p2)) {
//			System.out.println("삭제완료");
//		}
//		for (Person p : list) {
//			System.out.println(p.toString());
//		}
//		
//		//****************************** 리스트 전 수업******
////		System.out.println("===S===");
////		Person[] persons = new Person[5];
////		persons[0] = p1;
////		persons[1] = s1;
////		persons[2] = new Student();
////		persons[3] = new Person("Lee", 25);
////		persons[4] = new Person();
////		
////		String searchName = "park";
////		for(Person P : persons) {
////			if (P.getName() != null && P.getName().equals(searchName))
////			System.out.println("찾을이름: " +P.toString());
////		 //펄슨클래스에는 에이지 까지만 정의되어있고
////		// 스튜던트클래스에는 스쿨까지 정의되어있다
////		
////		}
		
	} // e of main
} // end of class
