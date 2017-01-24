package com.ktds.jgu;

public class ArmyMain {

	public static void main(String[] args) {
		
		// 군인 객체를 만들어 주는 클래스
		Army army = new Army();
		
		// makeArmy가 Person 객체를 만들어 kdj에 할당한다.
		Person kdj = army.makeArmy("김도준");
		System.out.println(kdj.getName());
		System.out.println(kdj.getJob());
		
		Person jsm = army.makeArmy("조성만");
		System.out.println(jsm.getName());
		System.out.println(jsm.getJob());
		
		
	}
	
}
