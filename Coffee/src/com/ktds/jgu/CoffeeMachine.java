package com.ktds.jgu;

public abstract class CoffeeMachine {

	protected int atm = 9;
	
	public void espresso() {
		System.out.println(atm + "기압으로 에스프레소를 추출합니다.");
	}
	
	// 추상적인지 모르기 때문에 abstract를 붙여서 
	// latte()가 추상메소드인지 알려준다.
	public abstract void latte();
	
}
