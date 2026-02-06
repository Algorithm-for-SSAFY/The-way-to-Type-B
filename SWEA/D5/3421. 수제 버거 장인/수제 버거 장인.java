
import java.util.*;
import java.io.*;

public class Solution {

	static int T, N, M, cnt;
	static int[] ingredi;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cnt = 0;
			ingredi = new int[M];
			
			
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int tmp = 0;
				int tmpbit1 = Integer.parseInt(st.nextToken())-1;
				int tmpbit2 = Integer.parseInt(st.nextToken())-1;
				ingredi[j] = tmp | (1 << tmpbit1) | (1 << tmpbit2);

			}

			for (int j = 0; j < (1 << N); j++) {
				boolean isTrue = true;
				for (int z = 0; z < M; z++) {
					if (Integer.bitCount(j & ingredi[z]) == 2) {
						isTrue = false;
						break;
					}
				}
				if(isTrue) {
					++cnt;
				} 
			}
			sb.append("#").append(i).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
