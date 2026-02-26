import java.io.*;
import java.util.*;

public class Main {

	static int V, E;
	static int[] parent;
	static ArrayList<Edge> edgeLst;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		edgeLst = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeLst.add(new Edge(start, end, weight));
		}
		
		Collections.sort(edgeLst);

		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		int finalCost= 0;
		int connectEdge = 0;
		
		for (Edge edge : edgeLst) {
			if (find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				finalCost += edge.weight;
				connectEdge++;
				
				if(connectEdge == V -1) break;
			}
		}
		
		System.out.println(finalCost);

	}
	
	public static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA != rootB) {
			if (rootA < rootB) parent[rootB] = rootA;
			else parent[rootA]= rootB;
		}
	}

}



class Edge implements Comparable<Edge> {
	int start;
	int end;
	int weight;

	Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

}