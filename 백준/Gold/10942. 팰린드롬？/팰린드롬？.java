import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] numbers;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		numbers = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int d=0; i-d>=1 && i+d<=N; d++) {
				if(numbers[i-d] == numbers[i+d] && (d==0 || dp[i-d+1][i+d-1] == 1)) {
					dp[i-d][i+d] = 1;
				} else {
					break;
				}
			}
		}
		for(int i=1; i<=N-1; i++) {
			for(int d=0; i-d>=1 && i+1+d<=N; d++) {
				if(numbers[i-d] == numbers[i+1+d] && (d == 0 || dp[i-d+1][i+d] == 1)) {
					dp[i-d][i+1+d] = 1;
				} else {
					break;
				}
			}
		}
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sb.append(dp[S][E]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
