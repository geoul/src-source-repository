import java.util.Scanner;

public class WeatherSub1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while ( true ) {  // while을 true로 하면 무한루프.(무한루프 이용할 경우 많이 씀.)
			System.out.println("지금 날씨는 어떤가요?");
			System.out.println("1. 비가 옵니다.  2. 맑습니다.  3. 종료");
			int selectWeather = input.nextInt();
			
			if(selectWeather == 1) {
				System.out.println("우산을 챙겨가세요.");
			}
			else if(selectWeather == 2){
				System.out.println("우산은 필요없어요.");
			}
			// 사용자가 3번을 선택했다면, 반복을 종료한다.
			else {
				// for, while 반복문을 즉시 종료시키는 키워드.
				break;
			}
		}
	}
}
