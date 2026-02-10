

import java.io.*;
import java.util.*;

public class Solution {

	static int T,N;
	static boolean[] col, slash, bSlash;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i<=T; i++) {
			N = Integer.parseInt(br.readLine());
			col = new boolean[N];
			slash = new boolean[2*N-1];
			bSlash = new boolean[2*N-1];
			cnt = 0;
			dfs(0,N);
			
			sb.append("#").append(i).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	
	public static void dfs(int row, int n) {
		//끝
		if (n==0) {
			cnt++;
			return;
		}
		
		if(row > N) {
			return;
		}
		
		for (int i = 0; i<N; i++) {
			if(col[i] || slash[row+i] || bSlash[(row-i)+N-1]) continue;
				
			col[i] = slash[row+i] = bSlash[(row-i)+N-1] = true;
			dfs(row+1,n-1);
			col[i] = slash[row+i] = bSlash[(row-i)+N-1] = false;
		}
	}
}
