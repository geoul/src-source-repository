package com.ktds.jgu;

public class OilBank {

	private int oilStock; // 기름보유량
	private int pricePerLiter; // 리터당 가격
	private int budget; // 돈(자금)

	public void setOilStock(int oilStock) {
		this.oilStock = oilStock;
	}

	public int getOilStock() {
		return oilStock;
	}

	public void setPricePerLiter(int pricePerLiter) {
		this.pricePerLiter = pricePerLiter;
	}

	public int getPricePerLiter() {
		return pricePerLiter;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getBudget() {
		return budget;
	}

	public void filling(Car car) {
		this.oilStock -= car.getOilTankVolume();  //주유소가 차의 오일탱크 용량만큼 주유한다.(기름보유량에서 오일탱크 용량만큼 뺀다.)
		
		System.out.println(this);
		car.fillOil(this);  //주유소가 차에 기름을 넣는다.
		//여기서 this는 filling을 호출한 객체(Main에서의 oilBank)
		
		this.budget += (pricePerLiter * car.getOilTankVolume());  //주유소가 주유값을 받는다.(리터당가격을 리터수만큼 곱해서 자산을 더한다).ㅣ
	}

}
