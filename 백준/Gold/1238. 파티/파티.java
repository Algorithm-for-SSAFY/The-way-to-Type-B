import java.util.*;
import java.io.*;

public class Main {
	static int N, M, X;
	static class Connection implements Comparable<Connection> {
		int num;
		int time;
		public Connection(int num, int time) {
			this.num = num;
			this.time = time;
		}
		@Override
		public int compareTo(Connection c) {
			return this.time - c.time;
		}
	}
	static List<Connection>[] connectedFrom;
	static List<Connection>[] connectedTo;
	static Integer[] minimumTo;
	static Integer[] minimumFrom;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		connectedFrom = new List[N+1];
		connectedTo = new List[N+1];
		for(int i=1; i<=N; i++) {
			connectedFrom[i] = new ArrayList<>();
			connectedTo[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) { 
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			connectedFrom[E].add(new Connection(S, T));
			connectedTo[S].add(new Connection(E, T));
		}
		dijkstra(X);
		int answer = 0;
		for(int i=1; i<=N; i++) {
			answer = Math.max(answer, minimumTo[i] + minimumFrom[i]);
		}
		sb.append(answer).append("\n");
		bw.write(sb.toString());
		bw.flush();
	}
	public static void dijkstra(int startNum) {
		boolean[] visited = new boolean[N+1];
		minimumTo = new Integer[N+1];
		minimumTo[startNum] = 0;
		visited[startNum] = true;
		PriorityQueue<Connection> pq = new PriorityQueue<>();
		for(Connection c : connectedTo[startNum]) {
			minimumTo[c.num]= c.time; 
			pq.offer(c);
		}
		while(!pq.isEmpty()) {
			Connection current = pq.poll();
			int cn = current.num;
			int ct = current.time;
			if(visited[cn]) {
				continue;
			}
			visited[cn] = true;
			for(Connection next : connectedTo[cn]) {
				int nn = next.num;
				int nt = next.time;
				if(minimumTo[nn] == null || minimumTo[nn] > ct + nt) {
					minimumTo[nn] = ct + nt;
					pq.offer(new Connection(nn, ct+nt));
				}
			}
		}
		visited = new boolean[N+1];
		minimumFrom = new Integer[N+1];
		minimumFrom[startNum] = 0;
		visited[startNum] = true;
		pq.clear();
		for(Connection c : connectedFrom[startNum]) {
			minimumFrom[c.num] = c.time; 
			pq.offer(c);
		}
		while(!pq.isEmpty()) {
			Connection current = pq.poll();
			int cn = current.num;
			int ct = current.time;
			if(visited[cn]) {
				continue;
			}
			visited[cn] = true;
			for(Connection next : connectedFrom[cn]) {
				int nn = next.num;
				int nt = next.time;
				if(minimumFrom[nn] == null || minimumFrom[nn] > ct + nt) {
					minimumFrom[nn] = ct + nt;
					pq.offer(new Connection(nn, ct+nt));
				}
			}
		}
	}
}