package com.ktds.jgu;

public class Cafe2 {

	public static void main(String[] args) {
		
//		CoffeeMachine coffeeMachine = new CoffeeMachine();
		// CoffeeMachine은 추상클래스라서 만들 수가 없다.
		
		CoffeeMachine coffeeMachine = new EspressoMachine();
		CoffeeMachine latteMachine = new LatteMachine();
		CoffeeMachine chocoLatteMachine = new ChocoLatteMachine();
		
		Barista barista = new Barista();
		barista.coffee(coffeeMachine);
		barista.coffee(latteMachine);
		barista.coffee(chocoLatteMachine);
		
	}
}
