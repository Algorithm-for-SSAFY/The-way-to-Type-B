import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int[][] paper;
	static boolean[][] visited;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int M;
	static int N;
	static int cnt = 0;
	static int res = 0;
	static int papercnt = 0;

	public static void bfsP(int x, int y) {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.offer(new int[] {x,y});
		
		while(!deque.isEmpty()) {
			int[] xy = deque.poll();
			int x1 = xy[0];
			int y1 = xy[1];
			visited[x1][y1] = true;
			for(int i=0;i<4;i++) {
				int nx = x1 + dx[i];
				int ny = y1 + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny] && paper[nx][ny] == 1) {
					deque.offer(new int[] {nx,ny});
					visited[nx][ny] = true;
					cnt++;
				}
			}
		}
		
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 세로
		M = Integer.parseInt(st.nextToken());// 가로
		

		visited = new boolean[N][M];
		paper = new int[N][M];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					paper[n][m] = Integer.parseInt(st.nextToken());
				}
			}

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(paper[i][j] == 1 && !visited[i][j]) {
					//paper가 1이고 방문한 적 없을 때
					cnt++;
					bfsP(i,j);
					res = Math.max(res, cnt);
					cnt = 0;
					papercnt++;
				}
			}
		}
		System.out.println(papercnt);
		System.out.println(res);

	}
}