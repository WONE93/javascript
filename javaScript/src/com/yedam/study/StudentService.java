package com.yedam.study;

import java.util.List;

public interface StudentService { //인터페이스는 클래스에서 필드를 쏙빼고 매소드만 실행되어야하는 구문이 없이 정의만 한다
							//인터페이스는 매소드를 정의만 하고 구현하는 클래스를 통해 구현한다.
	public List<Student> getStudList(); // 리스트는 여러건을 받겠다
	
	
	public Student getStudent(int employee_id); //인스턴스 하나만 받겠다 즉 조회조건으로 ID값 지정 후에 따라오는 값들 나오게
}
