package com.yedam.country;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {
	Connection conn = null;

	public CountryDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String passwd = "hr";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("정상적으로 연결되었습니다.");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("연결중 에러가 발생했습니다.");
			e.printStackTrace();
		}
	} // End of DAO

	public List<Country> getConList() {
		// firstName => name, salary=>age, email=>school
		String sql = "select * from countries";
		List<Country> list = new ArrayList<>();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Country c1 = new Country(rs.getString("country_id"), 
										rs.getString("country_name"),
										rs.getInt("region_id"));
				list.add(c1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	
	public Country getConInfo(String country_id) {
		String sql = "select * from contries where country_id = ?";
		Country c = new Country();

		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, country_id);
			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				c.setrId(rs.getInt("region_id"));
				c.setcName(rs.getString("country_name"));
				c.setcId(rs.getString("country_id"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return c;
	}

}// End of Class
