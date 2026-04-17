import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		print(n,m);
		
	}
	
	public static void print(int n,int m) {
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				System.out.print(1);
			}
			System.out.println();
		}
	}

}
