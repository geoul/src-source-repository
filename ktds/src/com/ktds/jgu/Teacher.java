package com.ktds.jgu;

public class Teacher {

	/* 절차지향방법 start
	public void teach(String subject) {
		System.out.println(subject + "를 가르칩니다.");
	}
	절차지향방법 end */
	
	// 객체관계 방법
	public void teach(String subject, Student student) {
		System.out.println(subject + "를 가르칩니다.");
		student.study(subject); // student가 공부합니다 subject를.
	}
	
}
