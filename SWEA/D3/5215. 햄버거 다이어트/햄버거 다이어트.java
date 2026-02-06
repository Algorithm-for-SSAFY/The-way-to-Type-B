

import java.io.*;
import java.util.*;

public class Solution{
	
	static int T;
	static int N;
	static int L;
	static int input[][];
	static int MaxDel;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			input = new int[N][2];
			MaxDel = 0;
			
			for (int j = 0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				input[j][0] = Integer.parseInt(st.nextToken());
				input[j][1] = Integer.parseInt(st.nextToken());
			}
			
			fit(0,0,0);
			
			sb.append("#").append(i).append(" ").append(MaxDel).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void fit(int depth,int sum, int delicious) {
		if (sum > L) {
			return;
		}
		
		MaxDel = Math.max(MaxDel, delicious);
		
		if (depth == N) {
			return;
		}
		
		fit(depth + 1,sum+input[depth][1], delicious+input[depth][0]);
		fit(depth + 1,sum, delicious);

		
	}
}
