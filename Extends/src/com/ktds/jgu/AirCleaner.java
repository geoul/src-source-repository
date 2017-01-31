package com.ktds.jgu;

public class AirCleaner {

	public String manufactor = "휘센";  // 브랜드
	protected String origin = "한국";  // 원산지
	private int power = 3;  // 세기
	
	public void powerOn() {
		System.out.println("공기청정기를 가동합니다.");
		System.out.println("공기가 맑아집니다.");
	}
	
}
