package com.ktds.jgu.buyer;

import com.ktds.jgu.seller.Seller;

/**
 * 
 * Seller에게 상품을 구매하고 금액을 Seller에게 지불한다.
 * 
 * @author Admin
 *
 */
public class Buyer {

	/**
	 * 상품개수
	 */
	private int productQuantity;
	
	/**
	 * 구매자가 가진 금액
	 */
	private int money;
	
//	생성자의 위치는 멤버변수 바로 밑에
	public Buyer(int productQuantity, int money) {
		System.out.println("구매자를 생성합니다!");
		
		//초기값 셋팅
		setProductQuantity(productQuantity);
		setMoney(money);
		
		// 현황 출력하기
		System.out.println(this);
	}
	
	/**
	 * 상품 개수를 초기화 또는 갱신함.
	 */
	public void setProductQuantity(int productquantity) {
		this.productQuantity = productQuantity;
	}
	
	/**
	 * 상품 개수를 반환함.(출력용)
	 * @return
	 */
	public int getProductQuantity() {
		return this.productQuantity;
	}
	
	/**
	 * 구매자의 금액을 초기화 또는 갱신함.
	 * @param money
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
	 * 구매자가 가진 돈을 반환함.(출력용)
	 * @return
	 */
	public int getMoney() {
		return this.money;
	}
	
	/**
	 * 구매하기
	 * 구매자가 가진 상품 개수에 1 더해준다.
	 */
	public void buy(Seller seller) {
		seller.sell(this);  // this는 buy()를 호출한 객체.(= lyj)
		
		this.productQuantity++;
	}
	
	/**
	 * 지불하기
	 * 구매자가 가진 돈에서 지불할 돈을 뺀다.
	 * @param money : 지불할 금액
	 */
	public void pay(int money) {
		this.money -= money;
	}
	
	/**
	 * 구매자 현황 파악하기
	 */
	@Override
	public String toString() {
		
		String message = 
				String.format("구매한 상품 개수 : %d\n구매자가 가진 금액 : %d", 
						this.productQuantity, this.money);
		
		return message;
	}
	
}
