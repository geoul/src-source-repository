package com.ktds.jgu;

public class Room2 {

	public static void main(String[] args) {
		AirCleaner airCleaner = new AirConditioner();
		// Sub Class가 Super Class에 할당되어진다.
		airCleaner.powerOn();
	}
	
}
