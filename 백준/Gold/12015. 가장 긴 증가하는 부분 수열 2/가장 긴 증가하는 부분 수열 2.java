import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(arr[0]);
		for(int i=1; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int num = arr[i];
			if(ts.last() < num) {
				ts.add(num);
			} else {
				int a = ts.ceiling(num);
				ts.remove(a);
				ts.add(num);
			}
		}
		int answer = ts.size();
		bw.write(answer + "\n");
		bw.flush();
	}
}
