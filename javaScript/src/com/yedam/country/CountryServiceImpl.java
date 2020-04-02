package com.yedam.country;

import java.util.List;

public class CountryServiceImpl implements CountryService {
	
	CountryDAO dao = new CountryDAO();

	@Override
	public List<Country> getConList() {
		// TODO Auto-generated method stub
		return dao.getConList();
	}

	@Override
	public Country getConInfo(String country_id) {
		// TODO Auto-generated method stub
		return dao.getConInfo(country_id);
	}
	
	
}
