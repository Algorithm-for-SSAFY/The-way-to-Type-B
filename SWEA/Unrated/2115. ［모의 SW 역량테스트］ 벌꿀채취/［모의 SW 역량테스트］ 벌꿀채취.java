import java.util.*;
import java.io.*;

public class Solution {

    static int T;
    static int N;
    static int M;
    static int C;
    static int[][] input;
    static boolean[][] visited;
    static int TmpMax;
    static int FinalMax;

    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 테스트 케이스 수
        T = Integer.parseInt(br.readLine());

        for(int i = 1; i<=T ; i++) {
        	st = new StringTokenizer(br.readLine());
        	// 입력받을 배열의 길이 
            N = Integer.parseInt(st.nextToken());
            // 부분 배열의 최대 길이
            M = Integer.parseInt(st.nextToken());
            // 담을 수 있는 최대 꿀
            C = Integer.parseInt(st.nextToken());
            // 입력받은 배열
            input = new int[N][N];
            // 방분 확인 배열
            visited = new boolean[N][N];
            
            // 배열 입력 받음
            for (int j = 0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k =0; k<N; k++) {
                    input[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            
            FinalMax = 0;
            
            int[] h1 = new int[M];
            int[] h2 = new int[M];
            
            //부분 배열 1 구하기
            for (int j = 0; j<N; j++) {
                for (int k =0; k<N-M+1; k++) {
                	for(int k1 = 0; k1 <M; k1++) {
                		h1[k1] = input[j][k+k1];
                		visited[j][k+k1] = true;
                	}
                	
                	// 부분배열 1 최대값 구하기
                	TmpMax = 0;
                	honey_collection(h1,0,0,0);
            		int profit1 = TmpMax;
                	
            		// 부분 배열 2 구하기
                	for(int l = j; l <N; l++) {
                		for(int m = 0; m<N-M+1; m++) {
                			if (visited[l][m]) continue;
                			for(int m1 = 0; m1 <M; m1++) {
                        		h2[m1] = input[l][m+m1];
                        	}
                			
                			// 부분배열 2 최대값 구하기
                			TmpMax = 0;
                        	honey_collection(h2,0,0,0);
                    		int profit2 = TmpMax;
                    		
                    		if (profit1 + profit2 > FinalMax) {
                    			FinalMax = profit1 + profit2;
                    		}
                		}
                	}
                }
            }
            sb.append("#").append(i).append(" ").append(FinalMax).append("\n");
        }
        System.out.println(sb);
    }
    
    public static void honey_collection(int[] h, int depth, int sum, int profit) {
    	if (sum > C) {
    		return;
    	}
    	
    	TmpMax = Math.max(TmpMax, profit);
    	
    	// 깊이가 M이면 return
    	if (depth == M) {
    		return;
    	}
    	
    	// 현재 꿀통을 선택했을 시
    	honey_collection(h, depth + 1, sum + h[depth], profit + h[depth]*h[depth]);
    	
    	// 현재 꿀통을 선택하지 않았을 시
    	honey_collection(h, depth + 1, sum, profit);
    }
}
