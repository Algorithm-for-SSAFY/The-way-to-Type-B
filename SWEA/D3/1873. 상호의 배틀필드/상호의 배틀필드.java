

import java.util.*;
import java.io.*;

public class Solution {

    static int T;
    static int H,W;
    static char[][] input;
    static int N;
    static String str;
    static int cx;
    static int cy;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 1; i<=T; i++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            input = new char[H][W];

            for (int j = 0; j<H; j++) {
                String tmp = br.readLine();
                for (int k = 0; k<W; k++) {
                    input[j][k] = tmp.charAt(k); 
                    if ("<^>v".indexOf(input[j][k]) != -1) {
                        cx = j;
                        cy = k;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            str = br.readLine();

            for (int j = 0; j<N; j++) {
                char command = str.charAt(j);

                if (command == 'S') {
                    shoot();
                } else {
                    go(command);
                }
            }

            sb.append("#").append(i).append(" ");
            for(int j = 0; j<H; j++) {
                for(int k = 0; k<W; k++) {
                    sb.append(input[j][k]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void shoot() {
        int tcx;
        int tcy;
        int i;
        switch (input[cx][cy]) {
        case '^':
            i = 1;
            while(true) {
                tcx = cx + dx[0]*i;
                tcy = cy + dy[0]*i;
                i++;
                if(tcx >= 0 && tcy >= 0 && tcx < H && tcy < W ) {
                    if (input[tcx][tcy] == '#') {
                        break;
                    } else if (input[tcx][tcy] == '*') {
                        input[tcx][tcy] = '.';
                        break;
                    }
                } else {
                    break;
                }
            }
            break;
        case '>':
            i = 1;
            while(true) {
                tcx = cx + dx[1]*i;
                tcy = cy + dy[1]*i;
                i++;
                if(tcx >= 0 && tcy >= 0 && tcx < H && tcy < W ) {
                    if (input[tcx][tcy] == '#') {
                        break;
                    } else if (input[tcx][tcy] == '*') {
                        input[tcx][tcy] = '.';
                        break;
                    }
                } else {
                    break;
                }
            }
            break;
        case 'v':
            i = 1;
            while(true) {
                tcx = cx + dx[2]*i;
                tcy = cy + dy[2]*i;
                i++;
                if(tcx >= 0 && tcy >= 0 && tcx < H && tcy < W ) {
                    if (input[tcx][tcy] == '#') {
                        break;
                    } else if (input[tcx][tcy] == '*') {
                        input[tcx][tcy] = '.';
                        break;
                    }
                } else {
                    break;
                }
            }
            break;
        case '<':
            i = 1;
            while(true) {
                tcx = cx + dx[3]*i;
                tcy = cy + dy[3]*i;
                i++;
                if(tcx >= 0 && tcy >= 0 && tcx < H && tcy < W ) {
                    if (input[tcx][tcy] == '#') {
                        break;
                    } else if (input[tcx][tcy] == '*') {
                        input[tcx][tcy] = '.';
                        break;
                    }
                } else {
                    break;
                }
            }
            break;
        }
    }

    public static void go(char command) {
        int tcx;
        int tcy;
        switch (command) {
        case 'U':
            input[cx][cy] = '^';
            tcx = cx + dx[0];
            tcy = cy + dy[0];

            if(tcx >= 0 && tcy >= 0 && tcx < H && tcy < W && input[tcx][tcy] == '.') {
                input[cx][cy] = '.';
                input[cx][cy] = '.';
                cx = tcx;
                cy = tcy;
                input[cx][cy] = '^';
            }
            break;
        case 'R':
            input[cx][cy] = '>';
            tcx = cx + dx[1];
            tcy = cy + dy[1];

            if(tcx >= 0 && tcy >= 0 && tcx < H && tcy < W && input[tcx][tcy] == '.') {
                input[cx][cy] = '.';
                input[cx][cy] = '.';
                cx = tcx;
                cy = tcy;
                input[cx][cy] = '>';
            }
            break;
        case 'D':
            input[cx][cy] = 'v';
            tcx = cx + dx[2];
            tcy = cy + dy[2];

            if(tcx >= 0 && tcy >= 0 && tcx < H && tcy < W && input[tcx][tcy] == '.') {
                input[cx][cy] = '.';
                input[cx][cy] = '.';
                cx = tcx;
                cy = tcy;
                input[cx][cy] = 'v';
            }
            break;
        case 'L':
            input[cx][cy] = '<';
            tcx = cx + dx[3];
            tcy = cy + dy[3];

            if(tcx >= 0 && tcy >= 0 && tcx < H && tcy < W && input[tcx][tcy] == '.') {
                input[cx][cy] = '.';
                input[cx][cy] = '.';
                cx = tcx;
                cy = tcy;
                input[cx][cy] = '<';
            }
            break;
        }
    }
}