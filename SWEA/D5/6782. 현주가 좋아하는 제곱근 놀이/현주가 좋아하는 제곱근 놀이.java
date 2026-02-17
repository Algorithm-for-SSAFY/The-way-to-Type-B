
import java.util.*;
import java.io.*;

public class Solution {
	
	static int T;
	static long N;
	static long minCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=T; i++) {
			N = Long.parseLong(br.readLine());
			minCnt = 0;
			solve(N,0);
			sb.append("#").append(i).append(" ").append(minCnt).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void solve(long num, long cnt) {
		if (num == 2) {
			minCnt = cnt;
			return;
		}
		
		if (Math.sqrt(num)*10%10 != 0) {
			long tmp1 = (long) Math.sqrt(num);
			long tmp = tmp1 + 1;
			long newN = (long) Math.pow(tmp, 2);
			long plusCnt =  newN - num;
			solve( (long) Math.sqrt(newN), cnt + plusCnt+1);
		} else {
			solve((long) Math.sqrt(num), cnt+1);
		}
		
	}

}
