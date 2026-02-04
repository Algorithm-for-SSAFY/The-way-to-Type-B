

import java.io.*;
import java.util.*;


public class Main  {
	
	static int n;
	static int s;
	static int[] input;
	static int cnt;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		input = new int[n];
		visited= new boolean[n];
		cnt = 0;
             		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i<n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if (input[i] == s) {
				cnt++;
			}
		}
		
		for (int i = 2; i<=n; i++) {
			dfs(0, 0, i, 0);
		}
		System.out.println(cnt);
		
	}
	
	public static void dfs(int depth, int start, int maxD,int val) {
		if (depth == maxD) {
			if (val == s) {
				cnt++;
			}
			return;
		}
		
		for (int i = start; i<n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int tmpVal = val + input[i];
				dfs(depth+1,i, maxD, tmpVal);
				visited[i] = false;
			}
		}
	}
}