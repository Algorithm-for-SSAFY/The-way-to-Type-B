import java.util.*;
import java.io.*;

public class Main {
	
	static List<List<Integer>> Lst = new ArrayList<>();
	static int[] indegree;
	static int N,M;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		indegree = new int[N + 1];
		
		for (int i = 0;i<=N; i++) {
			Lst.add(new ArrayList<>());
		}
		
		for (int i = 0;i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			Lst.get(start).add(end);
			indegree[end]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		List<Integer> result = new ArrayList<>();
		
		for (int i = 1;i<=N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while (!q.isEmpty()) {
			int idx = q.poll();
			result.add(idx);
			
			for(int next : Lst.get(idx)) {
				indegree[next]--;
				
				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		if (result.size() != N) {
			System.out.println(-1);
		} else {
			for(int idx : result) {
				System.out.print(idx+" ");
			}
		}
		
		
		
	}

}
