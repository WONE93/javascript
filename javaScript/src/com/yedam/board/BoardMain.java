package com.yedam.board;

import java.util.List;

public class BoardMain {
public static void main(String[] args) {
	
	//전체조회
	BoardDAO b = new BoardDAO();
	List<Board> blist = b.getBoardList();
	for(Board bd : blist) {
		System.out.println(bd.toString());
	}
	
	//한건삽입
	Board board = new Board();
	board.setWr("user2");
	board.setCo("java test");
	
	b.insertBoard(board);
	
	//한건조회
	board = b.getBoardInfo(2);
	System.out.println(board); 
	


}	
	
}
