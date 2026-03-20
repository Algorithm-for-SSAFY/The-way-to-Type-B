import java.util.*;
import java.io.*;

public class Main {
	static int V, E;
	static int[] parents;
	static class Connection implements Comparable<Connection> {
		int num1;
		int num2;
		int weight;
		public Connection(int num1, int num2, int weight) {
			this.num1 = num1;
			this.num2 = num2;
			this.weight = weight;
		}
		@Override
		public int compareTo(Connection c) {
			return this.weight - c.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents = new int[V+1];
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
		Connection[] connections = new Connection[E];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			connections[i] = new Connection(A, B, C);
		}
		Arrays.sort(connections);
		long sum = 0L;
		int count = 0;
		for(int i=0; i<E; i++) {
			if(count == V-1) {
				break;
			}
			Connection c = connections[i];
			int num1 = c.num1;
			int num2 = c.num2;
			if(union(num1, num2)) {
				sum += c.weight;
				count++;
			}
		}
		bw.write(sum + "\n");
		bw.flush();
	}
	public static boolean union(int num1, int num2) {
		int root1 = findRoot(num1);
		int root2 = findRoot(num2);
		if(root1 == root2) {
			return false;
		} else {
			parents[root1] = root2;
			return true;
		}
	}
	public static int findRoot(int num) {
		if(parents[num] == num) {
			return num;
		}
		parents[num] = findRoot(parents[num]);
		return parents[num];
	}
}
