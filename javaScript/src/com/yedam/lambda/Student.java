package com.yedam.lambda;

public class Student {
	private String name;
	private String sex;
	private int englishScore;
	private int mathScore;
	
	public Student() {}
	
	public Student(String name, String sex, int englishScore, int mathScore) {
		super();
		this.name = name;
		this.sex = sex;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}
	
	public Student(String name,  int englishScore, int mathScore) {
		super();
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSex() {
		return sex;
	}
	
	public int getEnglishScore() {
		return englishScore;
	}
	
	public int getMathScore() {
		return mathScore;
	}
	

	
}
