package com.yedam.study;

public class Student extends Person {  //펄슨(부모)클래스가 가지고있는 기능 모두 가지고 있어서 에이지 네임 게터엔세터 안만들어도됨
		
	private String school;

	public Student() {
	super();
}

	public Student(String name, int age, String school) {
		super(name,age);	
		this.school = school;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	} // 부모가 가진 매소드를 재정의 해서 달리 보고 싶을때

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Student [name=" +super.getName()+ ", age=" +super.getAge()+ ", school=" +school+ "]";
//		return super.toString();
	} // 부모가 가진 매소드를 재정의 해서 달리 보고 싶을때 
	
	
	
}
