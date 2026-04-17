import java.util.*;
import java.io.*;

public class Main {
	
	static int[] num = {1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int minimum = Math.min(a, Math.min(b, c));
		System.out.println(minimum);
	}
	
	
}
