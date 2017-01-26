package com.ktds.jgu;

public class StudentMain {

	public static void main(String[] args) {
		Student jgu = new Student();
		
		jgu.introduce();
		jgu.study();
		// jgu.name = "고흥수";
		jgu.setName("고흥수");
		
		jgu.introduce();
		jgu.setGrade(1);
		jgu.setGroup(206);
		jgu.introduce();
		
		jgu.setSchool("서울고등학교");
		jgu.study();
		
//		jgu.setSubject(subject);
		jgu.coding();
		
		Student sjm = new Student();
		sjm.setName("손진무");
		sjm.setGrade(1);
		sjm.setGroup(201);
		sjm.setSchool("ktds");
		
	}
	
}
