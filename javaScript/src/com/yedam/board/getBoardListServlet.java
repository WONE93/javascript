package com.yedam.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@WebServlet("/getBoardListServlet")
public class getBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public getBoardListServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		BoardDAO b = new BoardDAO();
//		List<Board> blist = b.getBoardList();
//     	
//		String bdJson = "[";
//     	int rCnt = 0;
//     	int totalCnt = blist.size();
//     	for(Board bd : blist) {
//			bdJson += "{\"board_no\":"+bd.getBoardNo()
//					+",\"content\":\""+bd.getCo()
//					+",\"writer\":\""+bd.getWr()
//					+"\",\"create_date\":\""+bd.getDate()+"\"}\r\n";
//					if(++rCnt != totalCnt)
//					bdJson += ",";  //두개가 같아지는 시점엔 , 안찍게
//					
//			
//		}
//	
//		bdJson += "]";
//		PrintWriter out = response.getWriter();
//		out.print(bdJson.toString());
		
	JSONObject obj = new JSONObject();
	JSONArray ary = new JSONArray();
	BoardDAO b = new BoardDAO();
	for(Board bd : b.getBoardList()) {
		obj.put("board_no", bd.getBoardNo());
		obj.put("content", bd.getCo());
		obj.put("writer", bd.getWr());
		obj.put("create_date", bd.getDate());
		ary.add(obj);
	}
	PrintWriter out = response.getWriter();
	out.print(ary.toString());
	
	} // End of doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

} // End of post
