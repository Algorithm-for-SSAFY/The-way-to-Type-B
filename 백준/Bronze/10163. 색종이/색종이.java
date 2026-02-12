import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] paper = new int[1001][1001];

		int N = Integer.parseInt(br.readLine());// 장수
		for (int p = 1; p <= N; p++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int i = x; i < x+w; i++) {
				for (int j = y; j < y+h; j++) {
					paper[i][j] = p;
				}
			}
		}
		int[] cnt = new int[N+1];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if (paper[i][j] !=0) {
					cnt[(paper[i][j])]++;
				}
			}
		}
		for(int i=1;i<N+1;i++) {
			sb.append(cnt[i]).append("\n");
		}

		System.out.println(sb.toString());

	}
}