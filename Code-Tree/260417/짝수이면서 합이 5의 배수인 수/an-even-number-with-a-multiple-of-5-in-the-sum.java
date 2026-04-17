import java.util.*;
import java.io.*;

public class Main {
	
	static int[] num = {1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		
		System.out.println(print(a));
		
	}
	
	public static String print(String n) {
		int numN = Integer.parseInt(n);
		if (numN%2 == 0) {
			int result = 0;
			for (int i = 0; i<n.length(); i++) {
				result += n.charAt(i)-'0';
			}
			if(result%5 == 0) {
				return "Yes";
			} 
		}
		return "No";
	}
}
