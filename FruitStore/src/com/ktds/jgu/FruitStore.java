package com.ktds.jgu;

import com.ktds.jgu.customer.Customer;
import com.ktds.jgu.seller.Seller;

/**
 * 
 * 1. 과일 가게 프로그램을 만들어 보세요.
 *    1. 과일 가게의 등장인물을 정하고
 *    2. 등장인물의 역할을 정의하세요.
 *    3. 등장인물의 프로세스대로 애플리케이션을 만들어 보세요.
 *    등장인물 : 판매자, 손님
 * 
 * @author Admin
 *
 */
public class FruitStore {

	public void start() {
		
		Customer customer = new Customer("포도", 0, 100000);
		Seller seller = new Seller(10, 200000);
		
		customer.buy(seller);
		
		System.out.println(customer);
		System.out.println(seller);
		
	}
	
	public static void main(String[] args) {
		new FruitStore().start();
	}
	
}
