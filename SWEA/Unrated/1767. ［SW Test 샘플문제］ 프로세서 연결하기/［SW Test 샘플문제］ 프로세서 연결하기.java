

import java.util.*;
import java.io.*;

public class Solution{

    static int T,N;
    static int[][] input;
    static int MinWire,MaxCore;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int i = 1; i<=T; i++) {
            N = Integer.parseInt(br.readLine());
            input = new int[N][N];
            MinWire= Integer.MAX_VALUE;
            MaxCore = Integer.MIN_VALUE;

            for (int j = 0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k<N; k++) {
                    input[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0);
            
            sb.append("#").append(i).append(" ").append(MinWire).append("\n");

        }
        System.out.println(sb);
    }


    public static void dfs(int depth) {
    	
    	
        if (depth == N*N) {
            int coreCnt =0;
            int wireCnt =0;
            for (int i = 0; i<N; i++) {
                for (int j = 0; j<N; j++) {
                	if (input[i][j] == 2) coreCnt++;
                    if (input[i][j] == - 1) wireCnt++;
                }
            }
            
            if (coreCnt > MaxCore) {
                MaxCore = coreCnt;
                MinWire = wireCnt;
            } else if (coreCnt == MaxCore) {
                MinWire = Math.min(MinWire, wireCnt);
            }
            return;
        }
        
        int startX = depth/N;
    	int startY = depth%N;
        
    	// 코어 아니거나 가장자리 코어면 다음칸으로
        if (startX==0 || startX == N-1 || startY==0 || startY == N-1 || input[startX][startY] != 1) {
        	dfs(depth+1);
        	return;
        }
        
        
        for (int k = 0; k <4; k++) {
        	
            int cx = startX;
            int cy = startY;
            boolean isTrue = true;

            int t = 1;
            while (true) {
                int nx = cx + dx[k] * t;
                int ny = cy + dy[k] * t;
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                
            	if (input[nx][ny] != 0) {
                    isTrue = false;
                    break;
                }
                ++t;
            }

            if (isTrue) {
                t = 1;
                while (true) {
                    int nx = cx + dx[k] * t;
                    int ny = cy + dy[k] * t;
                    
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                    
                	input[nx][ny] = -1;
                    ++t;
                }
                
                input[startX][startY] = 2;
                
                dfs(depth+1);

                input[startX][startY] = 1;
                
                t = 1;
                while (true) {
                    int nx = cx + dx[k] * t;
                    int ny = cy + dy[k] * t;
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                    input[nx][ny] = 0;
                    ++t;
                }
            } 
        }
        dfs(depth+1);
    }
}
