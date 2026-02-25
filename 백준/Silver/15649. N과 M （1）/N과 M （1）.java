import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static List<Integer> seq = new ArrayList<>();
	static int M;
	static boolean[] visited;
	public static void dfsS(int end, int leng) {
		//만약 길이가 M을 넣었을 경우 종료
		if(seq.size() == leng) {
			for(int s : seq) {
				sb.append(s).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=end;i++) {
			if(visited[i]) {
				continue;
			}
			seq.add(i);
			visited[i] = true;
			dfsS(end,leng);
			seq.remove(seq.size()-1);
			visited[i] = false;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//1~N
		int M = Integer.parseInt(st.nextToken());//길이 M
		visited = new boolean[N+1];
		
		dfsS(N, M);
		System.out.println(sb);

	}
}