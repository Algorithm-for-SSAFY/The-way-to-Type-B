import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static double E;
	static int[][] islands;
	static int[] roots;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			islands = new int[N][2];
			roots = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i][1] = Integer.parseInt(st.nextToken());
				roots[i] = i;
			}
			E = Double.parseDouble(br.readLine());
			double answer = Math.round(PRIM());
			sb.append("#").append(testCase).append(" ").append((long) answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	static class Tunnel {
		int num1;
		int num2;
		double cost;

		public Tunnel(int num1, int num2) {
			this.num1 = num1;
			this.num2 = num2;
			this.cost = getCost(num1, num2);
		}
	}

	public static double getCost(int num1, int num2) {
		return E * (Math.pow(islands[num1][0] - islands[num2][0], 2)
				+ Math.pow(islands[num1][1] - islands[num2][1], 2));
	}

	public static double PRIM() {
		boolean[] visited = new boolean[N];
		int visitedCount = 0;
		double sum = 0.0;
		PriorityQueue<Tunnel> pq = new PriorityQueue<>(new Comparator<Tunnel>() {
			@Override
			public int compare(Tunnel t1, Tunnel t2) {
				return Double.compare(t1.cost, t2.cost);
			}
		});
		for (int i = 1; i < N; i++) {
			pq.offer(new Tunnel(0, i));
		}
		visited[0] = true;
		visitedCount++;
		while (!pq.isEmpty()) {
			Tunnel t = pq.poll();
			int num1 = t.num1;
			int num2 = t.num2;
			if(visited[num2]) {
				continue;
			}
			if (union(num1, num2)) {
				sum += t.cost;
				visited[num2] = true;
				visitedCount++;
				if (visitedCount == N) {
					return sum;
				}
				for (int i = 0; i < N; i++) {
					if (num2 == i) {
						continue;
					}
					if (!visited[i]) {
						pq.offer(new Tunnel(num2, i));
					}
				}
			}
		}
		return sum;
	}

	public static boolean union(int num1, int num2) {
		if (roots[num1] == roots[num2]) {
			return false;
		}
		roots[roots[num1]] = roots[num2];
		return true;
	}

	public static int find(int num) {
		List<Integer> list = new ArrayList<>();
		while (roots[num] != num) {
			list.add(num);
			num = roots[num];
		}
		for (int i : list) {
			roots[i] = num;
		}
		return num;
	}
}