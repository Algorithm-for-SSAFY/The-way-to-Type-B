import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] bingo = new int[5][5];
	static boolean[][] itsBingo = new boolean[5][5];

	public static int searchBingo() {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {// 세로
			int col = 0;
			for (int j = 0; j < 5; j++) {
				if (itsBingo[j][i]) {
					col++;
				}
			}
			if (col == 5) {
				cnt++;
			}
		}
		for (int i = 0; i < 5; i++) {// 가로
			int row = 0;
			for (int j = 0; j < 5; j++) {
				if (itsBingo[i][j]) {
					row++;
				}
			}
			if (row == 5) {
				cnt++;
			}
		}
		
		//대각선1
		if(itsBingo[0][0] && itsBingo[1][1] && itsBingo[2][2] && itsBingo[3][3] && itsBingo[4][4]) {
			cnt++;
		}
		//대각선2
		if(itsBingo[0][4] && itsBingo[1][3] && itsBingo[2][2] && itsBingo[3][1] && itsBingo[4][0]) {
			cnt++;
		}
		
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 빙고판

		int flag = 0;
		int res = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int say = Integer.parseInt(st.nextToken());
				res++;
				for (int k = 0; k < 5; k++) {
					for (int z = 0; z < 5; z++) {
						if (say == bingo[k][z]) {
							itsBingo[k][z] = true;
							flag = 1;
							break;
						}
					}
					if (flag == 1) {
						flag = 0;
						break;
					}
				} // 사회자의 말과 같은 칸 찾기
				int cnt = searchBingo();
				if (cnt >= 3) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				break;
			}

		} // 사회자 말

		System.out.println(res);

	}
}
