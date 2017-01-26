package com.ktds.jgu;

public class Main {

	public static void main(String[] args) {
		
		OilBank oilBank = new OilBank();
		oilBank.setOilStock(5000);
		oilBank.setPricePerLiter(1480);
		oilBank.setBudget(0);
		
		Car car = new Car("무쏘", 50, 10000000);
		
		System.out.println(oilBank);
		oilBank.filling(car);  // 무쏘한테 50리터만큼 주유한다.
		
		System.out.println("======== 주유소 ========");
		System.out.println(oilBank.getOilStock());
		System.out.println(oilBank.getBudget());
		
		System.out.println("======== 자동차 ========");
		System.out.println(car.getModelName());
		System.out.println(car.getOilTankVolume());
		System.out.println(car.getOilStock());
		System.out.println(car.getMoney());
	}
	
}
