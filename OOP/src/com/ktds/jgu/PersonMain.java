package com.ktds.jgu;

public class PersonMain {

	public static void main(String[] args) {
		
		Person khw = new Person(); 
		// 메모리에 객체를 만들어주고 반환시키는데, 
		// 생성될 때 추가적인 작업을 해주고 싶다면 
		// Person()에 데이터를 넣어주면됨.
		khw.setName("김형우");
		khw.setJob("프로그래머");
		khw.introduce();
		
		Person ibj = new Person();
		ibj.setName("인병주");
		ibj.setJob("축구선수");
		ibj.introduce();
		
		Person pmw = new Person();
		pmw.setName("박민우");
		pmw.setJob("백수");
		pmw.introduce();
		
		Person unknown = new Person();
		unknown.introduce();
		
		Person ksk = new Person("김슬기", "감독");
		ksk.introduce();
	}
}
