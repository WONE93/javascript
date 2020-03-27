package com.yedam.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetEmpListServlet
 */
@WebServlet("/GetEmpListServlet")
public class GetEmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetEmpListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
//		response.getWriter().append("Served at: ").append(request.getContextPath()).append(" shw ");
		EmpDAO dao = new EmpDAO();
     	List<Employee> empList = dao.getEmpList();
//		[{"id":1,"first_name":"Sheryl","last_name":"Kane","email":"skane0@sina.com.cn","gender":"Female","ip_address":"250.201.187.56"},

     	String empJson = "[";
     	int rCnt = 0;
     	int totalCnt = empList.size();
		for(Employee e : empList) {
			empJson += "{\"empId\":"+e.getEmployeeId()
					+",\"firstName\":\""+e.getFirstName()
					+"\",\"lastName\":\""+e.getLastName()+"\"}";
					if(++rCnt != totalCnt)
					empJson += ",";  //두개가 같아지는 시점엔 , 안찍게
					
					
		}
		
		empJson += "]";
		PrintWriter out = response.getWriter();
		out.print(empJson.toString());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
