import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static boolean[] arr = new boolean[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<=100; i++) {
			if(i == 2 || i == 3) {
				arr[i] = true;
			} else {
				arr[i] = arr[i - 3];
			}
		}
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
		 	sb.append(divide(N)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static String divide(int num) {
		if(!arr[num]) {
			return "impossible";
		}
		if(num == 2) {
			return "BA";
		}
		if(num == 3) {
			return "BBA";
		}
		return divide(num-3) + "BBA";
	}
}
