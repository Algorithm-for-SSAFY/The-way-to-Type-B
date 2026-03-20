import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int[] roots;
	static class Road implements Comparable<Road> {
		int num1;
		int num2;
		int cost;
		public Road(int num1, int num2, int cost) {
			this.num1 = num1;
			this.num2 = num2;
			this.cost = cost;
		}
		@Override
		public int compareTo(Road r) {
			return this.cost - r.cost;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		roots = new int[N+1];
		for(int i=1; i<=N; i++) {
			roots[i] = -1;
		}
		PriorityQueue<Road> pq = new PriorityQueue<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			pq.offer(new Road(A, B, C));
		}
		int sum = 0;
		int cityCount = N;
		while(!pq.isEmpty()) {
			if(cityCount == K) {
				break;
			}
			Road r = pq.poll();
			if(union(r.num1, r.num2)) {
				sum += r.cost;
				cityCount--;
			}
		}
		bw.write(sum + "\n");
		bw.flush();
	}
	public static boolean union(int num1, int num2) {
		int root1 = find(num1);
		int root2 = find(num2);
		if(root1 == root2){
			return false;
		}
		if(roots[root1] > roots[root2]) {
			roots[root1] = root2;
		} else if(roots[root1] < roots[root2]) {
			roots[root2] = root1;
		} else {
			roots[root1] = root2;
			roots[root2]--;
		}
		return true;
	}
	public static int find(int num) {
		List<Integer> list = new ArrayList<>();
		while(roots[num] > 0) {
			list.add(num);
			num = roots[num];
		}
		for(int n : list) {
			roots[n] = num;
		}
		return num;
	}
}
