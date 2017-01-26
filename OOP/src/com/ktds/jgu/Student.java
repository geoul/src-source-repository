package com.ktds.jgu;

public class Student {

	private String name = "장거울";
	private String school = "ktds University";
	private int grade = 3;
	private int group = 201;
	private String subject[] = {"프로그래밍", "Java", "JSP", "DataBase"};
	
	// instance field에 대해서 setter 생성.
	/**
	 *  name 인스턴스 필드를 갱신함.
	 */
	public void setName(String name) {
		// 파라미터로 전달된 데이터의 길이가 3이면 변경을 해준다.(이름이 3글자이면 변경을 해준다.)
		if(name.length() == 3) {
			this.name = name; // instance field인 name에 파라미터에 있는 name을 할당하겠다.
		}
	}
	
	public void setSchool(String school) {
		this.school = school;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public void setGroup(int group) {
		this.group = group;
	}
	
	public void setSubject(String[] subject) {
		if(subject.length == 2) {
			this.subject = subject;
		}
	}
	
	public void study() {
		String studyMessage = String.format("%s은 %s에서 공부를 한다.", name, school);
		System.out.println(studyMessage);
	}
	
	public void introduce() {
		String introduceMessage = String.format("안녕하세요 %s입니다. %d학년 %d반 입니다.", name, grade, group);
		System.out.println(introduceMessage);
	}
	
	public void coding() {
		int count = subject.length - 2;
		for(int i = 0; i < count; i++) {
			String codingMessage = String.format("%s은 " + subject[i] + " 코딩을 하고있다.", name);
			System.out.println(codingMessage);
		}
	}
}
