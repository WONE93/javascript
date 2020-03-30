<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.yedam.board.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>getBoard.jsp</title>
</head>
<body>
		
		
	
	<%
		String boardNo = request.getParameter("boardNo");
		BoardDAO b = new BoardDAO();
		Board bd = b.getBoardInfo(Integer.parseInt(boardNo));
	%>
	
	<h1><a href="getBoardList.html">Board List</a></h1>
	<table border=1> 
		<tr>
			<td>BoardNo</td>
			<td><%= boardNo %></td>
		</tr>
		<tr>
			<td>Content</td>
			<td><%= bd.getCo() %></td>
		</tr>
		<tr>
			<td>Write</td>
			<td><%= bd.getWr() %></td>
		</tr>
		<tr>
			<td>Create_date</td>
			<td><%= bd.getDate() %></td>
		</tr>			
	</table>

</body>
</html>