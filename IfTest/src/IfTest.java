
public class IfTest {

	public static void main(String[] args) {
		
		/*
		 * 주머니에 돈이 1200원 이상 있다면, 캔커피를 살 수 있습니다.
		 * 를 출력하는 프로그램
		 */
		
		/*
		// 주머니에 있는 돈을 설정함.
		int moneyInPocket = 1000;
		
		// 주머니에 돈이 1200원 이상인지 확인함.
		boolean isOver1200 = moneyInPocket >= 1200;  // true (1000이 들어가면 false)
		if( isOver1200 ) {  // boolean 타입이 들어올 경우에만 "= true" 생략 가능.
			// moneyInPocket = 1000 이면 false이기 때문에 아무것도 실행이 안됨.
			// 1200원 이상이라면, "캔커피를 살 수 있습니다."를 출력함.
			System.out.println("캔커피를 살 수 있습니다!");
		}
		*/
		
		/*
		 *  술집에 입장한 사람의 나이가 10대 일 경우 "입장할 수 없습니다!"를 출력하는 프로그램
		 */
		
		// 나이를 설정한다.
		int age = 19;
		
		// 나이가 10대 인지 확인한다.
		boolean isTeenager = age < 20;
		
		if( isTeenager ) {
			System.out.println("입장할 수 없습니다.");
		} else {
			System.out.println("입장이 가능합니다.");
		}
		
		boolean getCard = true;
		
		if (getCard) {
			System.out.println("카드로 계산이 가능합니다.");
		} else {
			System.out.println("현금 계산이 가능합니다.");
		}
		
		
	}
	
}
