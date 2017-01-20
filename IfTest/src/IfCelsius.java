import java.util.Scanner;

public class IfCelsius {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("온도 변환기(1 ~ 2 중 선택)");
		int selectCelsius = input.nextInt();
		final double CELSIUS_SUB_NUM = 1.8;
		final int CELSIUS_ADD_NUM = 32;
		
		if (selectCelsius == 1) {
			// 2-1. 1을 입력하면 섭씨에서 화씨로 변경
			// 섭씨를 화씨로 : (섭씨 * 1.8) + 32
			System.out.print("섭씨 입력 : ");
			double celsius = input.nextDouble();
			
			double celsiusResult = (celsius * CELSIUS_SUB_NUM) + CELSIUS_ADD_NUM;
			System.out.println("화씨로 변환 : " + celsiusResult);
		} 
		else {
			// 2-2. 2를 입력하면 화씨에서 섭씨로 변경
			// 화씨를 섭씨로 : (화씨 - 32) / 1.8
			System.out.print("화씨 입력 : ");
			double fahrenheit = input.nextDouble();
			
			double fahrenheitResult = (fahrenheit - CELSIUS_ADD_NUM) / CELSIUS_SUB_NUM;
			System.out.println("섭씨로 변환 : " + fahrenheitResult);
		}
	}
}
