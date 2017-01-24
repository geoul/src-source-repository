package com.ktds.jgu.seller;

import com.ktds.jgu.customer.Customer;
/**
 * 
 * 판매자 : 과일을 판매한다.
 *         (남은 과일의 수, 판매자가 가진 금액)
 * 
 * @author Admin
 *
 */
public class Seller {
	/**
	 * 과일 가격
	 */
	private final int FRUIT_PRICE = 3000;
	
	/**
	 * 판매자가 가진 과일 종류
	 */
	private String fruitType = "사과";
	
	/**
	 * 판매자가 가진 과일의 개수
	 */
	private int fruitCount;
	
	/**
	 * 판매자가 가진 금액
	 */
	private int money; 
	
//	public void sell(String fruitType, int fruitCount, int money) {
	public Seller(int fruitCount, int money) {
		System.out.println("판매자가 손님에게 과일을 판매합니다!");
		
//		setFruitType(fruitType);
		setFruitCount(fruitCount);
		setMoney(money);
		
		System.out.println(this);
	}
	
//	public void setFruitType(String fruitType) {
//		this.fruitType = fruitType;
//	}
//	
//	public String getFruitType() {
//		return this.fruitType;
//	}
	
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
	 * 판매하기
	 */
	public void sell(Customer customer) {
		
		this.fruitCount--;
		
		customer.pay(FRUIT_PRICE);
		
		this.money += FRUIT_PRICE;
	}
	
	/**
	 * 재고 파악하기
	 * @return : boolean 재고가 있으면 false, 재고가 없으면 true
	 */
	public boolean isSoldOut() {
		boolean isSoldOut = this.fruitCount == 0;
		return isSoldOut;
	}
	
	/**
	 * 판매자 현황 파악하기
	 */
	@Override
	public String toString() {
		String message = String.format("판매자의 과일 개수 %d개,  판매자가 가진 금액 : %d.", 
				this.fruitCount, this.money);
		
		return message;
	}
    
}
