package com.ktds.jgu;

import java.util.Scanner;

public class Reservation {
	private final int SEAT = 24;
	private final int MONEY = 4000;
	 
	public void seatSelect() {
		  
		Scanner input = new Scanner(System.in);
			  
		//  System.out.println("좌석 예매할 사람 수를 입력해주세요.");
		//  int people = input.nextInt();
		//  int totalMoney = people * MONEY;
		System.out.println("좌석을 선택해주세요.(왼쪽 아래부터 위쪽 방향으로 1, 2번 순으로 진행)");
		System.out.println("프로그램 종료를 원하시면 99를 입력해주세요.");
		System.out.println("□ □ □ □ □ □ □ □ □ □ □ □");
		System.out.println("□ □ □ □ □ □ □ □ □ □ □ □");
			  
		int select = input.nextInt();
			  
		while(true) {
			 for(int i = 1; i <= SEAT; i++) {
		//	 for(int j = 1; j <= people; j++) {
			     
			 if(select == 1) {
			      System.out.println("□ □ □ □ □ □ □ □ □ □ □ □");
			      System.out.println("■ □ □ □ □ □ □ □ □ □ □ □");
			 } else if(select % 2 == 1){
			      System.out.println("□ □ □ □ □ □ □ □ □ □ □ □");
			      
			      switch(select) {
			      case 3:
			       System.out.println("□ ■ □ □ □ □ □ □ □ □ □ □");
			       break;
			      case 5:
			       System.out.println("□ □ ■ □ □ □ □ □ □ □ □ □");
			       break;
			      case 7:
			       System.out.println("□ □ □ ■ □ □ □ □ □ □ □ □");
			       break;
			      case 9:
			       System.out.println("□ □ □ □ ■ □ □ □ □ □ □ □");
			       break;
			      case 11:
			       System.out.println("□ □ □ □ □ ■ □ □ □ □ □ □");
			       break;
			      case 13:
			       System.out.println("□ □ □ □ □ □ ■ □ □ □ □ □");
			       break;
			      case 15:
			       System.out.println("□ □ □ □ □ □ □ ■ □ □ □ □");
			       break;
			      case 17:
			       System.out.println("□ □ □ □ □ □ □ □ ■ □ □ □");
			       break;
			      case 19:
			       System.out.println("□ □ □ □ □ □ □ □ □ ■ □ □");
			       break;
			      case 21:
			       System.out.println("□ □ □ □ □ □ □ □ □ □ ■ □");
			       break;
			      case 23:
			       System.out.println("□ □ □ □ □ □ □ □ □ □ □ ■");
			       break;
			      }
			} 
			else {
			      switch(select) {
			      case 2:
			       System.out.println("■ □ □ □ □ □ □ □ □ □ □ □");
			       break;
			      case 4:
			       System.out.println("□ ■ □ □ □ □ □ □ □ □ □ □");
			       break;
			      case 6:
			       System.out.println("□ □ ■ □ □ □ □ □ □ □ □ □");
			       break;
			      case 8:
			       System.out.println("□ □ □ ■ □ □ □ □ □ □ □ □");
			       break;
			      case 10:
			       System.out.println("□ □ □ □ ■ □ □ □ □ □ □ □");
			       break;
			      case 12:
			       System.out.println("□ □ □ □ □ ■ □ □ □ □ □ □");
			       break;
			      case 14:
			       System.out.println("□ □ □ □ □ □ ■ □ □ □ □ □");
			       break;
			      case 16:
			       System.out.println("□ □ □ □ □ □ □ ■ □ □ □ □");
			       break;
			      case 18:
			       System.out.println("□ □ □ □ □ □ □ □ ■ □ □ □");
			       break;
			      case 20:
			       System.out.println("□ □ □ □ □ □ □ □ □ ■ □ □");
			       break;
			      case 22:
			       System.out.println("□ □ □ □ □ □ □ □ □ □ ■ □");
			       break;
			      case 24:
			       System.out.println("□ □ □ □ □ □ □ □ □ □ □ ■");
			       break;
			      }
			      System.out.println("□ □ □ □ □ □ □ □ □ □ □ □");
		//	      System.out.println("금액 : " + totalMoney);
			      } 
		//	    }
			   }
			   if(select == 99) {
				   System.out.println("프로그램 종료!");
				   break;
			   }
		  }
	 }
}
