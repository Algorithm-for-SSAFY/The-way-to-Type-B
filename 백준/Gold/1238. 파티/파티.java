import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            Arrays.fill(arr[i], 1000000);
        }
        for(int i=1; i<=N; i++){
            arr[i][i] = 0;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int country1 = Integer.parseInt(st.nextToken());
            int country2 = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            arr[country1][country2] = time;
        }
        int[][] minArray = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            int[] minDistance = new int[N+1];
            Arrays.fill(minDistance, 1000000);
            boolean[] visited = new boolean[N+1];
            dijkstra(i, arr, minDistance, visited, N);
                        for(int j=1; j<=N; j++){
                minArray[i][j] = minDistance[j];
            }
        }
        int answer = 0;
        for(int i=1; i<=N; i++){
            if(minArray[i][X] == 1000000 || minArray[X][i] == 1000000){
                continue;
            }
            answer = Math.max(answer, minArray[i][X] + minArray[X][i]);
        }
        bw.write(answer + "\n");
        bw.flush();
    }

    public static void dijkstra(int num, int[][] arr, int[] minDistance, boolean[] visited, int N){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        minDistance[num] = 0;
        pq.offer(new Node(num, 0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            num = node.number;
            if(!visited[num]){
                visited[num] = true;
                for(int i=1; i<=N; i++){
                    if(visited[i]){
                        continue;
                    }
                    if(minDistance[i] > minDistance[num] + arr[num][i]){
                        minDistance[i] = minDistance[num] + arr[num][i];
                        pq.offer(new Node(i, minDistance[i]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int number;
        int distance;
        public Node(int number, int distance){
            this.number = number;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}
