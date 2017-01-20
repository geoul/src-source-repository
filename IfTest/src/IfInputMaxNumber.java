import java.util.Scanner;

public class IfInputMaxNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("가장 큰 수 출력");
		System.out.println("숫자 3개를 연달아 입력하세요.");
		
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		
		/*
		// 경우의 수 : 1,2 / 1,3 / 2,3
		boolean oneMatchingTwo = number1 >= number2;
		boolean oneMatchingThree = number1 >= number3;
		boolean TwoMatchingThree = number2 >= number3;
		
		int maxNumber = 0;
		if(oneMatchingTwo) {
			maxNumber = number1;
			if (oneMatchingThree) {
				maxNumber = number1;
			}
		} else {
			maxNumber = number2;
			if (TwoMatchingThree) {
				maxNumber = number2;
			} 
			else {
				maxNumber = number3;
			}
		}
		System.out.println("3개의 숫자 중 가장 큰 수 : " + maxNumber);
		*/
		
		// 삼항 연산 처리
		int maxNumber = (number1 > number2) ? number1 : number2;
		
		maxNumber = (maxNumber > number3) ? maxNumber : number3;
		
		System.out.println("3개의 숫자 중 가장 큰 수 : " + maxNumber);
	}
	
}
