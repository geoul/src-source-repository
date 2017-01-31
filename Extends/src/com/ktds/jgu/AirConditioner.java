package com.ktds.jgu;

public class AirConditioner extends AirCleaner {

	/**
	 * 냉방 설정 온도
	 */
	private int temp = 26;
	
	/**
	 * 전원 켬
	 */
	@Override  // 메소드 오버라이드 : 다시 한번 재정의 하겠다.
	public void powerOn() {
		System.out.println("에어컨을 켭니다.");
		System.out.println("시원해 집니다.");
		
		cooling();
		
		System.out.println("공기청정기 제조사 : " + super.manufactor);
		System.out.println("공기청정기 제조국가 : " + super.origin);
		
		super.powerOn();
		//상속받은 클래스(AirCleaner) Super Class에 있는 
		//똑같은 이름의 메소드를 실행시키려면 
		//super.을 붙여주면 된다.(Super Class 자신을 뜻함.)
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	/**
	 * 온도 낮추기
	 */
	public void cooling() {
		temp--;
		System.out.println("현재 설정 온도는 " + temp + "도 입니다.");
	}
}
