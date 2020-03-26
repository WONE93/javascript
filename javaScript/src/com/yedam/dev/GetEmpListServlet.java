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
//		 {"id":2,"first_name":"Ransom","last_name":"Fernely","email":"rfernely1@themeforest.net","gender":"Male","ip_address":"63.112.15.109"},
//		 {"id":3,"first_name":"Brunhilda","last_name":"Pitcaithly","email":"bpitcaithly2@icio.us","gender":"Female","ip_address":"32.56.167.26"},
//		 {"id":4,"first_name":"Noellyn","last_name":"Gawn","email":"ngawn3@eventbrite.com","gender":"Female","ip_address":"120.44.242.201"},
//		 {"id":5,"first_name":"Saundra","last_name":"Pennicard","email":"spennicard4@people.com.cn","gender":"Female","ip_address":"208.247.184.253"},
//		 {"id":6,"first_name":"Marena","last_name":"Emanuel","email":"memanuel5@slate.com","gender":"Female","ip_address":"145.75.133.201"},
//		 {"id":7,"first_name":"Rurik","last_name":"Cottrill","email":"rcottrill6@topsy.com","gender":"Male","ip_address":"5.20.235.209"},
//		 {"id":8,"first_name":"Wilton","last_name":"Clery","email":"wclery7@google.es","gender":"Male","ip_address":"166.245.148.230"},
//		 {"id":9,"first_name":"Torey","last_name":"Jillins","email":"tjillins8@rakuten.co.jp","gender":"Female","ip_address":"172.47.246.230"},
//		 {"id":10,"first_name":"Tades","last_name":"Gonsalvez","email":"tgonsalvez9@newsvine.com","gender":"Male","ip_address":"51.15.83.156"}]
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
