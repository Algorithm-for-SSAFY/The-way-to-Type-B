import java.util.*;
import java.io.*;

public class Main {
	
	static int[] num = {1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		//int m = Integer.parseInt(st.nextToken());
		
		print(n);
		
	}
	
	public static void print(int n) {
		for (int i = 0; i<n; i++) {
			for (int j = 0; j< n; j++) {
				System.out.print(num[(i*n + j)%9] + " ");
			}
			System.out.println();
		}
	}

}
