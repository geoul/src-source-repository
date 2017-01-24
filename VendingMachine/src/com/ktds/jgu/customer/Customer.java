package com.ktds.jgu.customer;

import com.ktds.jgu.machine.Machine;
/**
 * 기능
 * 1. 음료 남은 개수 계산
 * 2. 거스름돈 계산
 * 속성
 * 1. 음료 종류
 * 2. 가격
 * 
 * @author Admin
 *
 */
public class Customer {

//	String[] drinkType = {"토레타", "칸타타", "포카리스웨트", "게토레이"};
//	int[] drinkPrice = {2500, 2000, 1000, 1000};
//	int[] count = {20, 20, 20, 20};
	
	String drinkType1 = "토레타";
	String drinkType2 = "칸타타";
	String drinkType3 = "포카리스웨트";
	String drinkType4 = "게토레이";
	
	int drinkPrice1 = 2500;
	int drinkPrice2 = 2000;
	int drinkPrice3 = 1000;
	int drinkPrice4 = 1000;
	
	int count = 20;
	
	int money = 10000; //남은 돈
	String drink;
	String drinkName;
	
	public Customer(String drinkName, int money) {
		System.out.println("구입한 음료 입니다.");
		
//		setDrinkPrice(drinkPrice);
		setDrinkName(drinkName);
		setMoney(money);
		
		System.out.println(this);
	}
	
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	
	public String getDrinkName() {
		return this.drinkName;
	}
	
//	public void setDrinkPrice(int drinkPrice) {
//		this.drinkPrice = drinkPrice;
//	}
//	
//	public int getDrinkPrice() {
//		return this.drinkPrice;
//	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public void buy(Machine machine) {
		machine.selectDrink();
	}
	
	public String toString() {
		String message = String.format("구입한 음료는 %s이고 거스름돈은 %d입니다.", 
				this.drinkName, this.money);
		return message;
	}
	
}
