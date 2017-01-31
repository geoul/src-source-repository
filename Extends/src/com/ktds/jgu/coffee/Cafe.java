package com.ktds.jgu.coffee;

public class Cafe {

	public static void main(String[] args) {
		
		CoffeeMachine espressoMachine = new CoffeeMachine();
		espressoMachine.espresso();
		
		// Sub Class is a Super Class
		System.out.println("========== 라떼 머신 ==========");
		CoffeeMachine latteMachine = new LatteMachine();
		// 커피머신에는 라떼를 만드는 기능이 없다.
		
//		LatteMachine latte = (LatteMachine) latteMachine; // 아래는 단축형 표현
		((LatteMachine) latteMachine).latte();
		// 어디까지 캐스팅 할건지 범위를 잡아준다
		latteMachine.espresso();
		
		System.out.println(espressoMachine);
		System.out.println(latteMachine);
//		표면으로는 CoffeeMachine인데 내부적으로는 LatteMachine이다.
	}
}
