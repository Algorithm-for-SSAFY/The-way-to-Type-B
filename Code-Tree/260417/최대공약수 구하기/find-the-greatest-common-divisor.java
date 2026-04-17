import java.util.*;
import java.io.*;

public class Main {
	
	static int[] num = {1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		if (n>m) {
			System.out.println(gcd(n,m));
		} else {
			System.out.println(gcd(m,n));

		}
	}
	
	public static int gcd(int a,int b) {
		while(b !=0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	
	public static int lcm(int a,int b) {
		if (a == 0||b==0) return 0;
		
		return Math.abs(a*b) / gcd(a,b);
	}

}
