
public class ExampleFor {

	public static void main(String[] args) {
		
		String modula = "%";
		
		for(int low = 1; low <= 5; low++) {
			for(int count = 1; count <= low; count++) {
				System.out.print(modula);
			}
			System.out.println("");
		}
	}
	
}
