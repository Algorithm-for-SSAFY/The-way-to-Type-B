
import java.util.*;
import java.io.*;

public class Solution {
	
	static int T,N;
	static int[] dp = new int[100000];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i<=T; i++) {
			N = Integer.parseInt(br.readLine());
			sb.append("#").append(i).append(" ").append(dfs(N)).append("\n");
			
		}
		System.out.println(sb);
	}
	
	public static int dfs(int num) {
		if (num < 10) {
			return 0;
		}
		
		if (dp[num] != 0) {
			return dp[num];
		}
		
		String s = String.valueOf(num);
		int maxCnt = 0;
		int len = String.valueOf(num).length();
		for (int i = 1; i< (1<<(len-1)); i++) {
			int current = 1;
			int last = 0;
			
			for (int j = 0; j<len-1; j++) {
				if ((i &(1<<j)) != 0) {
					String tmp = s.substring(last, j+1);
					current *= Integer.parseInt(tmp);
					last = j+1;		
				}
			}
			
			String tmp = s.substring(last);
			current *= Integer.parseInt(tmp);
			
			
			int cnt = dfs(current) +1;
			maxCnt = Math.max(cnt, maxCnt);
			
		}
		
		dp[num] = maxCnt;
		return maxCnt;
	}
}
