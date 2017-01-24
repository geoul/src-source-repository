package com.ktds.jgu;

import com.ktds.jgu.buyer.Buyer;
import com.ktds.jgu.seller.Seller;

public class Store {

	public void start() {
		
//		int numberOne = 10;
//		int numberTwo = numberOne;
//		
//		numberTwo++;
//		System.out.println(numberOne);
//		System.out.println(numberTwo);
		
		Buyer lyj = new Buyer(0, 50000);
		Seller nym = new Seller(500, 50000);
		
		lyj.buy(nym); // lyj가 nym한테 구매한다.
		
		System.out.println(lyj);
		System.out.println(nym);
		
		// 레퍼런스 타입이 변수에 전달되었을 때, 같은 메모리 주소를 참조한다.
//		Buyer ljs = new Buyer(0, 5000000);
//		Buyer jgu = ljs;
		
//		ljs.buy();
//		
//		System.out.println(ljs);
//		System.out.println(jgu);
		
		
//		System.out.println("장터에 오신 것을 환영합니다.");
//		Buyer jjh = new Buyer(0, 500000);
//		Seller mjk = new Seller(100, 5000000);
//		
//		System.out.println("바이어 : 상품 좀 살게요. 이 상품 1개 주세요.");
//		mjk.sell();
//		jjh.buy();
//		
//		System.out.println("셀러 : 2500원 입니다.");
//		jjh.pay(2500);
//		
//		System.out.println(mjk);
//		System.out.println(jjh);
		
	}
	
	public static void main(String[] args) {
		
		new Store().start();
	}
//	public static void main(String[] args) {
//		
//		Buyer mjk = new Buyer(0, 100000);
//		
//		mjk.buy();
//		mjk.pay(2000);
//		
//		System.out.println(mjk);
//		
//		Seller jjh = new Seller(100, 10000);
//		
//		jjh.sell();
//		boolean isSoldOut = jjh.isSoldOut();
//		System.out.println(isSoldOut);
//		
//		System.out.println(jjh);
//	}
	
}
