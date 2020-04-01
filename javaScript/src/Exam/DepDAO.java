package Exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DepDAO {
	Connection conn = null;

	public DepDAO() {
		String user = "hr";
		String pass = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,pass);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
				
	}

	public List<Department> getDepList() {
		String sql = "select * from departments";
		List<Department> list = new ArrayList<>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Department dep = new Department();
				dep.setDepartmentId(rs.getInt("department_id"));
				dep.setDepartmenName(rs.getString("department_name"));
				dep.setManagerId(rs.getInt("manager_id"));
				dep.setLocationId(rs.getInt("location_id"));
				list.add(dep);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
