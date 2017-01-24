package com.ktds.jgu.machine;

import java.util.Scanner;
import com.ktds.jgu.customer.Customer;

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
public class Machine {

//	String[] drinkType = {"토레타", "칸타타", "포카리스웨트", "게토레이"};
//	int[] drinkPrice = {2500, 2000, 1000, 1000};
//	int[] count = {20, 20, 20, 20};
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
	int drinkPrice;
	
	public Machine(String drinkType, int count, int money) {
		System.out.println("자판기에서 음료를 선택합니다.");
		
		setDrinkCount(count);
		setMoney(money);
		
		System.out.println(this);
	}
	
	public void setDrinkCount(int count) {
		this.count = count;
	}
	
	public int getDrinkCount() {
		return this.count;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return this.money;
	}
	
//	public void selectDrink() {
//		for(int i = 0; i <= drinkType.length; i++) {
//			System.out.println("먹고 싶은 음료를 선택하세요.(0:토레타, 1:칸타타, 2:포카리스웨트, 3:게토레이)");
//			Scanner input = new Scanner(System.in);
//			int drink = input.nextInt();
////			String drinkName;
//			if(drinkType[drink] == drinkType[0]) {
//				drinkName = "토레타";
////				drinkPrice[i] = 2500;
//				money -= drinkPrice[i];
//				count[i] -= 1;
//			} else if(drinkType[drink] == drinkType[1]) {
//				drinkName = "칸타타";
////				drinkPrice[i] = 2000;
//				money -= drinkPrice[i];
//				count[i] -= 1;
//			} else if(drinkType[drink] == drinkType[2]) {
//				drinkName = "포카리스웨트";
////				drinkPrice[i] = 1000;
//				money -= drinkPrice[i];
//				count[i] -= 1;
//			} else if(drinkType[drink] == drinkType[3]) {
//				drinkName = "게토레이";
////				drinkPrice[i] = 1000;
//				money -= drinkPrice[i];
//				count[i] -= 1;
//			} else {
//				System.out.println("해당 음료가 없습니다.");
//			}
//		}
//	}
	
	public void selectDrink() {
			System.out.println("먹고 싶은 음료를 선택하세요.(1:토레타, 2:칸타타, 3:포카리스웨트, 4:게토레이)");
			Scanner input = new Scanner(System.in);
			int drink = input.nextInt();
//			String drinkName;
			if(drinkType1 == "토레타") {
				drinkName = "토레타";
				drinkPrice = drinkPrice1;
//				drinkPrice[i] = 2500;
				money -= drinkPrice1;
				count -= 1;
			} else if(drinkType2 == "칸타타") {
				drinkName = "칸타타";
				drinkPrice = drinkPrice2;
//				drinkPrice[i] = 2000;
				money -= drinkPrice2;
				count -= 1;
			} else if(drinkType3 == "포카리스웨트") {
				drinkName = "포카리스웨트";
//				drinkPrice[i] = 1000;
				money -= drinkPrice3;
				drinkPrice = drinkPrice3;
				count -= 1;
			} else if(drinkType4 == "게토레이") {
				drinkName = "게토레이";
//				drinkPrice[i] = 1000;
				money -= drinkPrice4;
				drinkPrice = drinkPrice4;
				count -= 1;
			} else {
				System.out.println("해당 음료가 없습니다.");
			}
	}
	
	public String toString() {
		String message = String.format("선택한 음료는 %s이고 남은 음료는 %d개이며 가격은 %d원 입니다.", 
				this.drinkName, this.count, this.drinkPrice);
		
		return message;
	}
	
	
	
	
}
