

import java.io.*;
import java.util.*;

public class Solution{
	
	static int[] gInput;
	static int[] IInput;
	static boolean[] isG;
	static boolean visited[];
	static int[] output = new int[9];
	static int tr = 0;
	static int fal = 0;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 1; i<=t; i++) {
			gInput = new int[9];
			IInput = new int[9];
			isG = new boolean[18];
			visited = new boolean[9];
			tr = 0;
			fal = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int j= 0; j<9; j++) {
				gInput[j] = Integer.parseInt(st.nextToken());
				isG[gInput[j]-1] = true;
			}
			
			int tmpIdx = 0;
			for (int j = 0; j<18; j++) {
				if(!isG[j]) {
					IInput[tmpIdx++] = j+1;
				}
			}
			dfs(0);
			
			sb.append("#").append(i).append(" ").append(tr).append(" ").append(fal).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int depth ) {
		if (depth == 9) {
			int gScore = 0;
			int IScore = 0;
			for (int i = 0; i<9; i++) {
				if(gInput[i] > output[i]) {
					gScore += gInput[i] + output[i];
				} else {
					IScore += gInput[i] + output[i];
				}
			}
			if(gScore > IScore) {
				tr++;
			} else if (gScore < IScore) {
				fal++;
			}
		}
		
		for (int i = 0; i<9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = IInput[i];
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}
}
