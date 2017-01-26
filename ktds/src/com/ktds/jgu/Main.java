package com.ktds.jgu;

public class Main {

	public static void main(String[] args) {
		
		/* 절차지향방법 start
		Teacher teacher = new Teacher();
		Student student = new Student();
		
		teacher.teach("Oracle Database");
		student.study("Oracle Database");
		절차지향방법 end */ 
		
		// 객체관계 방법
		Teacher teacher = new Teacher();
		Student student = new Student();  
		//변수의 선언부 Student student를 복사해서 teacher파라미터에 넣어준다.
		
		teacher.teach("Oracle Database", student); //teacher가 가르친다 student에게.
	}
	
}
