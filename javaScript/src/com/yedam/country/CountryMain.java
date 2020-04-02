package com.yedam.country;

import java.util.List;

import com.yedam.study.Student;

public class CountryMain {
	public static void main(String[] args) {
		
		
		CountryService service = new CountryServiceImpl();

//		List<Country> list = service.getConList();
////		Country ct = service.getConInfo(da);
//		System.out.println("한건조회" + ct);
		
		
		//리스트
		for (Country c : list) {
			System.out.println(c.toString());
		}
		service.getConList();

	}// end of main
} // end of class
