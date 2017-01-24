package com.ktds.jgu.customer;

import com.ktds.jgu.seller.Seller;


/**
 * 
 * 손님 : 과일을 구입한다.
 *       (구입한 과일의 수, 손님이 가진 금액)
 * 
 * @author Admin
 *
 */
public class Customer {

	private final int FRUIT_PRICE = 3000;
	private String fruitType = "사과";
	private int fruitCount;
	private int money; 
	
//	public void Customer(String fruitType, int FRUIT_PRICE, int fruitCount, int money) {
	public Customer(String fruitType, int fruitCount, int money) {
		System.out.println("손님이 판매자에게 과일을 구매합니다!");
		
		setFruitType(fruitType);
		setFruitCount(fruitCount);
		setMoney(money);
		
		System.out.println(this);
	}
	
	public void setFruitType(String fruitType) {
		this.fruitType = fruitType;
	}
	
	public String getFruitType() {
		return this.fruitType;
	}
	
	public void setFruitCount(int fruitCount) {
		this.fruitCount = fruitCount;
	}
	
	public int getFruitCount() {
		return this.fruitCount;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	/**
	 * 구매하기
	 * 구매자가 가진 상품 개수에 1 더해준다.
	 */
	public void buy(Seller seller) {
		seller.sell(this);  // this는 buy()를 호출한 객체.(= lyj)
		
		this.fruitCount++;
	}
	
	public void pay(int money) {
		this.money -= money;
	}
	
	public String toString() {
		String message = String.format("손님이 구입한 %s는 %d개이며 손님이 가진 금액은 %d원이다.", 
				this.fruitType, this.fruitCount, this.money * this.fruitCount);
		
		return message;
	}
	
}
