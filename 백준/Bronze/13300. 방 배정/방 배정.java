import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());// 학생 수
		int K = Integer.parseInt(st.nextToken());// 최대 인원 수

		int[][] student = new int[2][7];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			student[S][Y]++;
		} // 입력받는다

		int res =0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				res += (student[i][j]/K);
				if(student[i][j]%K!=0) {
					res++;
				}
				
			}
		}
		System.out.println(res);
		
		
		
		

	}
}
