import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int[][] xy = new int[num][2];
		boolean[][] paper = new boolean[100][100];
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			xy[i][0] = Integer.parseInt(st.nextToken());
			xy[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < num; i++) {
			int x = xy[i][0];
			int y = xy[i][1];
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					paper[j][k] = true;
				}
			}
		}
		int res = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(paper[i][j]) {
					res++;
				}
			}
		}

		System.out.println(res);

	}
}