import java.util.*;
import java.io.*;

public class Main {
	static long INF = 1000000000L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] numbers = new long[N+1];
		for(int i=1; i<=N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		long[] segmentTree = new long[N * 4];
		makeSegmentTree(numbers, segmentTree, 1, 1, N);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			long result = getMinimum(numbers, segmentTree, 1, 1, N, left, right);
			bw.write(result + "\n");
		}
		bw.flush();
	}
	public static void makeSegmentTree(long[] numbers, long[] segmentTree, int index, int start, int end) {
		if(start == end) {
			segmentTree[index] = numbers[start];
		} else {
			makeSegmentTree(numbers, segmentTree, index*2, start, (start+end)/2);
			makeSegmentTree(numbers, segmentTree, index*2+1, (start+end)/2+1, end);
			segmentTree[index] = Math.min(segmentTree[index*2], segmentTree[index*2+1]);
		}
	}
	public static long getMinimum(long[] numbers, long[] segmentTree, int index, int start, int end, int left, int right) {
		if(right < start || left > end) {
			return INF;
		}
		if(left <= start && end <= right) {
			return segmentTree[index];
		}
		long leftMin = getMinimum(numbers, segmentTree, index*2, start, (start+end)/2, left, right);
		long rightMin = getMinimum(numbers, segmentTree, index*2+1, (start+end)/2+1, end, left, right);
		return Math.min(leftMin, rightMin);
	}
}
