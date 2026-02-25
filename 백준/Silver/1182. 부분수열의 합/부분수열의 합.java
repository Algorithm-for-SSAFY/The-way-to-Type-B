import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> seq = new ArrayList<>();
	static int res = 0;
	static int N;
	static int S;
	static List<Integer> seqP = new ArrayList<>();
	
	public static void dfsS(int idx, int cSum) {
		if (idx == N) {
			if(cSum == S) res++;
			return;
		}
		
		dfsS(idx+1,cSum+seq.get(idx));
		dfsS(idx+1,cSum);
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// N개의 정수
		S = Integer.parseInt(st.nextToken());// 다 더한 값

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq.add(Integer.parseInt(st.nextToken()));
		}
		dfsS(0, 0);
		if(S==0) {
			res--;
		}

		System.out.println(res);
	}
}