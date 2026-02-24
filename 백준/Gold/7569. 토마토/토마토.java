import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int[][][] tomato;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int dh[] = { 1, -1 };
	static int H;
	static int M;
	static int N;
	static int day = 0;
	static Deque<int[]> deque = new ArrayDeque<int[]>();

	public static void bfsT() {
		int flag = 0;

		while (!deque.isEmpty()) {

			int size = deque.size();
			for (int s = 0; s < size; s++) {
				int[] hxy = deque.poll();
				int h1 = hxy[0];
				int x1 = hxy[1];
				int y1 = hxy[2];
				for (int i = 0; i < 2; i++) {// 위아래
					int nh = h1 + dh[i];
					if (nh >= 0 && nh < H && tomato[nh][x1][y1] == 0) {
						flag = 1;
						tomato[nh][x1][y1] = 1;
						deque.offer(new int[] { nh, x1, y1 });
					}
				}
				for (int j = 0; j < 4; j++) {// 상하좌우
					int nx = x1 + dx[j];
					int ny = y1 + dy[j];
					if (nx >= 0 && ny >= 0 && nx < N && ny < M && tomato[h1][nx][ny] == 0) {
						flag = 1;
						tomato[h1][nx][ny] = 1;
						deque.offer(new int[] { h1, nx, ny });
					}
				}

			}
			if (flag == 1) {
				day++;
				flag = 0;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());// 가로
		N = Integer.parseInt(st.nextToken());// 세로
		H = Integer.parseInt(st.nextToken());// 높이

		int cnt = 0;
		tomato = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					tomato[h][n][m] = Integer.parseInt(st.nextToken());
					if (tomato[h][n][m] == 0) {
						cnt++;
					}
				}
			}
		} // 입력 완료

		if (cnt == 0) { // 애초부터 다 익어있는 경우
			day = 0;
		} else {
			for (int h = 0; h < H; h++) {
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						if (tomato[h][n][m] == 1) {
							deque.offer(new int[] { h, n, m });
						}
					}
				}
			}
			bfsT();
		}

		// 다 익는 게 불가능한지 확인하기
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (tomato[h][n][m] == 0) {
						day = -1;
					}
				}
			}
		}
		System.out.println(day);

	}
}