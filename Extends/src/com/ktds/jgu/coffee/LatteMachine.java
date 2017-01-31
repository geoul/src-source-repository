package com.ktds.jgu.coffee;

public class LatteMachine extends CoffeeMachine {

	public LatteMachine() {
		super.atm = 15;  // CoffeeMachine에 있는 atm를 가리킴.
//		atm = 15; //여기에 있는 atm을 가리킴.
	}
	
	@Override  // 이걸 적어주면 컴파일이 빨라진다.
	public void latte() {
		System.out.println(super.atm + "기압으로 카페라떼를 추출합니다.");
	}
}
