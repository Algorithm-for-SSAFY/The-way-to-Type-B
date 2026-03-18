import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] numbers;
	static int[][] segmentTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		segmentTree = new int[2][N * 4];
		makeSegmentTree(1, 1, N);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(getValue(1, 1, N, a, b, 0) + " " + getValue(1, 1, N, a, b, 1) + "\n");
		}
		bw.flush();
	}

	public static void makeSegmentTree(int node, int start, int end) {
		if (start == end) {
			segmentTree[0][node] = numbers[start];
			segmentTree[1][node] = numbers[start];
		} else {
			makeSegmentTree(node * 2, start, (start + end) / 2);
			makeSegmentTree(node * 2 + 1, (start + end) / 2 + 1, end);
			segmentTree[0][node] = Math.min(segmentTree[0][node*2], segmentTree[0][node*2+1]);
			segmentTree[1][node] = Math.max(segmentTree[1][node*2], segmentTree[1][node*2+1]);
		}
	}

	public static int getValue(int node, int start, int end, int left, int right, int minimum) {
		if(right < start || end < left) {
			return -1;
		}
		if(left <= start && end <= right) {
			return segmentTree[minimum][node];
		}
		int leftValue = getValue(node*2, start, (start+end)/2, left, right, minimum);
		int rightValue = getValue(node*2+1, (start+end)/2+1, end, left, right, minimum);
		if(minimum == 0) {
			if(leftValue == -1) {
				return rightValue;
			} else if(rightValue == -1) {
				return leftValue;
			} else {
				return Math.min(leftValue, rightValue);
			}
		} else {
			if(leftValue == -1) {
				return rightValue;
			} else if(rightValue == -1) {
				return leftValue;
			} else {
				return Math.max(leftValue, rightValue);
			}
		}
	}
}
