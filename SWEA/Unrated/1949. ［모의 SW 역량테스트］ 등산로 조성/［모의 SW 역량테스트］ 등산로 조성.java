

import java.util.*;
import java.io.*;

public class Solution {

	static int T,N,K;
	static int input[][];
	static int maxH;
	static int maxCnt;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			input = new int[N][N];
			
			maxH = 0;
			maxCnt = Integer.MIN_VALUE;
			
			
			for (int j = 0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k<N; k++) {
					input[j][k] = Integer.parseInt(st.nextToken());
					maxH = Math.max(maxH, input[j][k]);
					
				}
			}
			find();
			
			sb.append("#").append(i).append(" ").append(maxCnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void find() {
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				if (input[i][j] == maxH) {
					visited = new boolean[N][N]; 
					dfs(i,j,1,true);
				}
			}
		}
	}
	
	public static void dfs(int cx, int cy, int cnt, boolean isTrue) {
		maxCnt = Math.max(maxCnt, cnt);
		visited[cx][cy] = true;
		for (int i = 0; i<4; i++) {
			int nx = cx+dx[i];
			int ny = cy+dy[i];
			
			if (nx>=0 && ny >=0 && nx<N && ny<N && !visited[nx][ny]) {
				if (input[nx][ny] < input[cx][cy]) {
					dfs(nx,ny,cnt+1,isTrue);
				} else if (input[nx][ny]-K < input[cx][cy] && isTrue) {
					int tmp = input[nx][ny];
					input[nx][ny] = input[cx][cy] -1;
					dfs(nx,ny,cnt+1,false);
					input[nx][ny] = tmp;
				} 
			} 
		}
		visited[cx][cy] = false;
	}
}
