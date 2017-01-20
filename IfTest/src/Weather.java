import java.util.Scanner;

public class Weather {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("지금 날씨는 어떤가요? (1 ~ 2 중 선택)");
		int selectWeather = input.nextInt();
		
		if(selectWeather == 1) {
			System.out.println("우산을 챙겨가세요.");
		}
		else {
			System.out.println("우산은 필요없어요.");
		}
		
	}
}
