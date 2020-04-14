package com.yedam.exam02;

public class Employee {
	String first_name;
	int salary;
	
	public Employee() {
		
	}
	
	public Employee(String first_name, int salary) {
		super();
		this.first_name = first_name;
		this.salary = salary;
	}

	public String getFirst_name() {
		return first_name;
	}

	public int getSalary() {
		return salary;
	}
	
	
	
}
