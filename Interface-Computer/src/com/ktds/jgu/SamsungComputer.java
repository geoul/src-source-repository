package com.ktds.jgu;

public class SamsungComputer implements Computer {

	@Override
	public void input() {
		// △ : 애매한 존재들을 처음으로 구체화 시키겠다.
		System.out.println("키보드와 마우스로 입력을 합니다.");
	}

	@Override
	public void compute() {
		System.out.println("Intel 7세대 CPU i7을 사용해 계산합니다.");
	}

	@Override
	public void store() {
		System.out.println("SSD에 저장합니다.");
	}	
}
