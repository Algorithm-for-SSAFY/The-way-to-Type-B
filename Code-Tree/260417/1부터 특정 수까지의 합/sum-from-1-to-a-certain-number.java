import java.util.*;
import java.io.*;

public class Main {
	
	static int[] num = {1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		// int m = Integer.parseInt(st.nextToken());
		
		System.out.println(print(n));
	
	}
	
	public static int print(int n) {
		int sum = 0;
		for (int i = 1; i<=n;i++) {
			sum+=i;
		}
		return sum/10;
	}
}
