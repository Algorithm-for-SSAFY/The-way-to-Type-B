import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] tree = new int[N];
			int max = 0;
			
			int odd = 0;
			int even = 0;
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(tree[i], max);
			}
			for(int i=0;i<N;i++) {
				odd+=(max-tree[i])%2;
				even+=(max-tree[i])/2;
			}
			//크기 조절
			int temp = Math.max((even-odd), 0)/3;
			//더 작은 걸로만 만들 수 있다
			odd += temp*2;
			even -= temp;
			int oddeven= Math.min(odd, even);
			int day = oddeven*2 + Math.max((odd-oddeven)*2-1, 0)+ Math.max((even-oddeven)/2*3, 0)+ Math.max((even-oddeven)%2*2, 0);
			
			sb.append("#").append(t).append(" ").append(day).append("\n");
		}
		System.out.println(sb);
	}
}