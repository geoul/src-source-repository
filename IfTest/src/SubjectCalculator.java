import java.util.Scanner;

public class SubjectCalculator {

	public static void main(String[] args) {
		
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
	}
	
}
