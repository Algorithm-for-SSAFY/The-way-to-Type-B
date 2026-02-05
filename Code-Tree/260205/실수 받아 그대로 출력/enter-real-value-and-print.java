import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double input = sc.nextDouble();
		input = Math.round(100*input)/100.0;
		System.out.println(input);
	}
}
