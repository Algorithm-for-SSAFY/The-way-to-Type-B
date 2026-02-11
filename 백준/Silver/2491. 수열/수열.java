import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cntB = 1;
		int cntS = 1;
		int res = 0;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] == arr[i+1]) {
				cntB++;
				cntS++;
			} 
			else if (arr[i] < arr[i+1]) {
				cntB++;
				res = Math.max(cntS, res);
				cntS = 1;
			} 
			else if (arr[i] > arr[i+1]) {
				cntS++;
				res = Math.max(cntB, res);
				cntB = 1;
			}
		}
		res = Math.max(cntB, res);
		res = Math.max(cntS, res);
		System.out.println(res);

	}
}