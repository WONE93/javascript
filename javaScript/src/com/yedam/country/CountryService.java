package com.yedam.country;

import java.util.List;

public interface CountryService {
	
	public List<Country> getConList();
	
	public Country getConInfo(String country_id);

}
