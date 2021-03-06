package com.yedam.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmpDAO {
	Connection conn = null;
	
	public EmpDAO() {
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
	
	public void insertEmp(Employee emp) {
		String sql = "insert into emp(employee_id, last_name, email, hire_date, job_id) "
				   + " values((select max(employee_id)+1 from emp),"
				   +"?, ?, sysdate, ?)"; 
		// ?에는 사용자 입력값 , 라스트네임,이메일,잡아이드 순서
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getLastName());
			pstmt.setString(2, emp.getEmail());
			pstmt.setString(3, emp.getJobId());
			int iCnt = pstmt.executeUpdate();
			System.out.println( iCnt + "건 입력.");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // End of insert 리턴값없음
	
	public List<Employee>  getEmpList() {
		String sql = "select * from employees";
		List<Employee> list = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("Manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
				list.add(emp);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
} // End of Class
