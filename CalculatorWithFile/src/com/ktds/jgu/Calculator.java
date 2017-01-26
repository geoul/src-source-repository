package com.ktds.jgu;

import com.ktds.jgu.helper.FileWriteHelper;

public class Calculator {
	
	private FileWriteHelper fileWriteHelper; // 멤버변수로 빼서 사용.
	
	public Calculator() {
		fileWriteHelper = new FileWriteHelper();
	}

	public void start() {
		int result = 10 + 70;
		String message = String.format("%d + %d = %d", 10, 70, result);
		System.out.println(message);
		
		FileWriteHelper.log(message);
		
//		FileWriteHelper fileWriteHelper = new FileWriteHelper(); // 멤버변수로 빼서 사용.
		fileWriteHelper.log(message);
		
	}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		new Calculator().start();
		
	}
}
