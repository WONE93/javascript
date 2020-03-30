package com.yedam.board;

public class Board {
	int boardNo;
	String Co;
	String Wr;
	String Date;

	@Override

	public String toString() {
		return "Board [boardNo=" + boardNo + ", Co=" + Co + ", Wr=" + Wr + ", Date=" + Date + "]";
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getCo() {
		return Co;
	}

	public void setCo(String co) {
		Co = co;
	}

	public String getWr() {
		return Wr;
	}

	public void setWr(String wr) {
		Wr = wr;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		this.Date = date;
	}

}
