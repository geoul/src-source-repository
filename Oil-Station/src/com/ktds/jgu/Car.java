package com.ktds.jgu;

public class Car {

	private String modelName; // 차 종류
	private int oilTankVolume; // 오일탱크 용량
	private int oilStock; // 기름보유량
	private int money; // 돈
	
	public Car(String modelName, int oilTankVolume, int money) {
		this.modelName = modelName;
		this.oilTankVolume = oilTankVolume;
		this.money = money;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getOilTankVolume() {
		return oilTankVolume;
	}

	public void setOilTankVolume(int oilTankVolume) {
		this.oilTankVolume = oilTankVolume;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public void setOilStock(int oilStock) {
		this.oilStock = oilStock;
	}
	
	public int getOilStock() {
		return oilStock;
	}
	
	public void fillOil(OilBank oilBank) {
		oilStock = oilTankVolume; // 기름보유량만큼 오일탱크용량을 채워라.(만땅 채워라.)
		
		this.money -= (oilTankVolume * oilBank.getPricePerLiter());  
		// 여기서 this는 매개변수의 this이다. 값을 할당하기 위한.
	}

}
