package com.yedam.study;

import java.util.List;

public class StudentServiceImpl implements StudentService { //구현한다는 의미로 Impl을 붙임

	EmpDAO dao = new EmpDAO();

	@Override
	public List<Student> getStudList() {
		return dao.getEmpList();
	}

	@Override
	public Student getStudent(int employee_id) {
		
		return dao.getStudent(employee_id);
	} 
	

}
