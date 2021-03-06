package com.yedam.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.dev.Employee;

public class BoardDAO {

	Connection conn = null;

	public BoardDAO() {
		String user = "hr";
		String pass = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertBoard(Board bd) {
		String sql = "insert into board " + "values( (select nvl(max(board_no),0)+1 from board)," + "? , ? , sysdate)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bd.getCo());
			pstmt.setString(2, bd.getWr());

			int iCnt = pstmt.executeUpdate();
			System.out.println(iCnt + "건 입력.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Board> getBoardList() {
		String sql = "select board_no, content, writer, create_date from board order by board_no desc";
		List<Board> list = new ArrayList<>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Board bd = new Board();
				bd.setBoardNo(rs.getInt("board_no"));
				bd.setCo(rs.getString("content"));
				bd.setWr(rs.getString("writer"));
				bd.setDate(rs.getString("create_date"));

				list.add(bd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	

	public Board getBoardInfo(int boardNo) {
		String sql = "select board_no, content, writer, create_date from board " + "where board_no = ? ";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Board bd = new Board();
				bd.setBoardNo(rs.getInt("board_no"));
				bd.setCo(rs.getString("content"));
				bd.setWr(rs.getString("writer"));
				bd.setDate(rs.getString("create_date"));
				return bd;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}

} // End of class