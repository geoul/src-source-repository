import java.util.Scanner;

public class Example2 {

	/*
	 * 2-1. 1을 입력하면 점수 5개의 총점, 평균을 계산하는 프로그램
	 * 2-2. 2를 입력하면 섭씨를 화씨로 변경하는 프로그램
	 * 2-3. 3을 입력하면 BMI를 계산하는 프로그램
	 * 2-4. 4를 입력하면 프로그램이 종료되도록 코딩하세요. 
	 */
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("숫자를 입력하세요. (1 : 총점&평균, 2 : 섭씨를 화씨로, 3 : BMI계산, 4 : 종료");
			int selectInput = input.nextInt();
			
			if(selectInput == 1) {
				
				System.out.print("프로그래밍 점수 : ");
				int programmingScore = input.nextInt();
				System.out.print("수학 점수 : ");
				int mathScore = input.nextInt();
				System.out.print("알고리즘 점수 : ");
				int algorithmScore = input.nextInt();
				System.out.print("영어 점수 : ");
				int englishScore = input.nextInt();
				System.out.print("경제 점수 : ");
				int economyScore = input.nextInt();
				
				int sum = programmingScore + mathScore + algorithmScore + englishScore + economyScore;
				double average = sum / 5.0;
				
				System.out.println("총점 : " + sum + ", 평균 : " + average);
				
			} 
			else if(selectInput == 2) {
				
				final double CELSIUS_SUB_NUM = 1.8;
				final int CELSIUS_ADD_NUM = 32;
				
				// 섭씨를 화씨로 : (섭씨 * 1.8) + 32
				System.out.print("섭씨 입력 : ");
				double celsius = input.nextDouble();
				
				double celsiusResult = (celsius * CELSIUS_SUB_NUM) + CELSIUS_ADD_NUM;
				System.out.println("화씨로 변환 : " + celsiusResult);
				
			} 
			else if(selectInput == 3) {
				
				System.out.print("체중 입력 : ");
				double weight = input.nextDouble();
				
				System.out.print("신장(키) 입력 : ");
				double height = input.nextDouble() * 0.01;
				
//				System.out.print("성별(남자/여자) 입력 : ");
//				String selectGender = input.next();
				
//				 BMI(비만도) 계산하기 (비만도 = 체중(kg)/신장(m2))
				double Bmi = weight / (height * height);
				
//				if(selectGender == "여자") {
					if(Bmi <= 18.5) {
						System.out.println("BMI(비만도) : " + Bmi + ", 저체중 입니다."); 
					} else if(Bmi <= 23) {
						System.out.println("BMI(비만도) : " + Bmi + ", 정상 입니다."); 
					} else if(Bmi <= 25) {
						System.out.println("BMI(비만도) : " + Bmi + ", 과체중 입니다."); 
					} else if(Bmi <= 30) {
						System.out.println("BMI(비만도) : " + Bmi + ", 비만 입니다."); 
					} else {
						System.out.println("BMI(비만도) : " + Bmi + ", 고도비만 입니다."); 
					}
//				} else {
//					if(Bmi <= 14.33) {
//						System.out.println("BMI(비만도) : " + Bmi + ", 저체중 입니다."); 
//					} else if(Bmi <= 19.15) {
//						System.out.println("BMI(비만도) : " + Bmi + ", 정상 입니다."); 
//					} else {
//						System.out.println("BMI(비만도) : " + Bmi + ", 과체중 입니다."); 
//					}
//				}
				
			} 
			else {
				
				System.out.println("프로그램 종료!");
				break;
				
			}
		}
		
	}
}
