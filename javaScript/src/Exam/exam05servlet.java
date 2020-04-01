package Exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.Board;
import com.yedam.board.BoardDAO;
import com.yedam.dev.Employee;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@WebServlet("/exam05servlet")
public class exam05servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public exam05servlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		JSONObject obj = new JSONObject();
		JSONArray ary = new JSONArray();
		DepDAO d = new DepDAO();
		for(Department dep : d.getDepList()) {
			obj.put("department_id", dep.getDepartmentId());
			obj.put("department_name", dep.getDepartmenName());
			obj.put("manager_id", dep.getManagerId());
			obj.put("location_id", dep.getLocationId());
			ary.add(obj);
			
		}
		PrintWriter out = response.getWriter();
		out.print(ary.toString());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
