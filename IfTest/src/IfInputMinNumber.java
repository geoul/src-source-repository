import java.util.Scanner;

public class IfInputMinNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("가장 작은 수 출력");
		System.out.println("숫자 3개를 연달아 입력하세요");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		
		int minNumber = (number1 < number2) ? number1 : number2;
		
		minNumber = (minNumber < number3) ? minNumber : number3;
		
		System.out.println("3개의 숫자 중 가장 작은 수 : " + minNumber);
	}
	
}
