import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int res = 0;
	static int cnt;
	static int[][] building;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N;

	static void dfsB(int x, int y, int rain) {
		visited[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && building[nx][ny] > rain) {
				dfsB(nx, ny, rain);
			}
		}

	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		building = new int[N][N];
		int maxB = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				building[i][j] = Integer.parseInt(st.nextToken());
				maxB = Math.max(maxB, building[i][j]);
			}
		}

		for (int rain = 0; rain < maxB; rain++) {
			cnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (building[i][j] > rain && !visited[i][j]) {
						// 빌딩이 잠긴 후의 안전지역 계산
						dfsB(i, j, rain);
						cnt++;
					}
				}
			}
			res = Math.max(res, cnt);
		}
		System.out.println(res);

	}
}