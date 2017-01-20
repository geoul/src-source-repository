import java.util.Scanner;

public class SubjectCalculator2 {

	public static void main(String[] args) {
		/*
		 * 프로그래밍, 경영, 수학, 알고리즘의 점수를 입력받아
		 * 총점과 평균을 구한다.
		 * 평균이 90점 이상이라면 "참 잘했어요!"를 출력하고
		 * 평균이 90점 미만이라면 "노력하세요!"를 출력하는 프로그램.
		 */
		Scanner input = new Scanner(System.in);
		System.out.print("프로그래밍 점수 : ");
		int programmingScore = input.nextInt();
		
		System.out.print("경영 점수 : ");
		int managementscore = input.nextInt();
		
		System.out.print("수학 점수 : ");
		int mathScore = input.nextInt();
		
		System.out.print("알고리즘 점수 : ");
		int algorithmScore = input.nextInt();
		
		int sum = programmingScore + managementscore + mathScore + algorithmScore;
//		System.out.println("총점 = " + sum);
		
		double average = sum / 4.0;
//		System.out.println("평균 = " + average);
		String message = String.format("총점은 %d점, 평균은 %.2f점 입니다.", sum, average);
		System.out.println(message);
		
		boolean isAverage = average >= 90;
		if(isAverage) {
			System.out.println("참 잘했어요!");
		}
		// 평균이 90점을 넘기지 못한다면 "노력하세요!"를 출력한다.
		// 위 조건(average >= 90)의 결과가 false 라면 "노력하세요!"를 출력한다.
		else {
			System.out.println("노력하세요!");
		}
	}
	
}
