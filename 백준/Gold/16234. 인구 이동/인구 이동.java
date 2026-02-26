import java.util.*;


import java.io.*;

public class Main {
	
	static int N,L,R;
	static int[][] input;
	static boolean[][] visited;
	static List<int[]> change;
	static int cnt;
	static int sum;
	static boolean isTrue;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L= Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		input = new int[N][N];
		
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		while(true) {
			isTrue = false;
			visited = new boolean[N][N];
			for (int i = 0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (visited[i][j]) continue;
					cnt = 0;
					sum = 0;
					change = new ArrayList<>();
					dfs(i,j);
					
					for(int[] x : change) {
						input[x[0]][x[1]] = sum/cnt;
					}
				}
			}
			
			if (!isTrue) {
				break;
			} else {
				result++;
			}
		}
		System.out.println(result);
			
	}
	
	public static void dfs(int x, int y) {
		cnt += 1;
		sum += input[x][y];
		visited[x][y] = true;
		int[] t = new int[2];
		t[0] = x;
		t[1] = y;
		change.add(t);
		
		for (int i = 0; i<4; i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			
			if (cx>=0 && cy>=0 && cx<N && cy<N && !visited[cx][cy]) {
				int tmp = Math.abs(input[cx][cy] - input[x][y]);
				if (tmp >= L && tmp<=R) {
					isTrue = true;
					dfs(cx,cy);
				}	
			}
		}
	}
}
