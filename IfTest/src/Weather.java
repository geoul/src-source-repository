import java.util.Scanner;

public class Weather {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++) {
			System.out.println("지금 날씨는 어떤가요?");
			System.out.println("1. 비가 옵니다.  2. 맑습니다.");
			int selectWeather = input.nextInt();
			
			if(selectWeather == 1) {
				System.out.println("우산을 챙겨가세요.");
			}
			else {
				System.out.println("우산은 필요없어요.");
			}
		}
	}
}
