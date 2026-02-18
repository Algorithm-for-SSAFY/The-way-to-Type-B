
import java.util.*;
import java.io.*;

class AP implements Comparable<AP>{
	int x;
	int y;
	int c;
	int p;
	
	AP (int x, int y, int c,int p){
		this.x = x;
		this.y = y;
		this.c = c;
		this.p = p;
	}

	@Override
	public int compareTo(AP o) {
		// TODO Auto-generated method stub
		return o.p - this.p;
	}
}

public class Solution {
	
	static int T,M,A;
	static int[] a;
	static int[] b;
	static List<AP> ap;
	
	static int[] ca;
	static int[] cb;
	static int total;
	
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			a = new int[M+1];
			b = new int[M+1];
			ap = new ArrayList<>();
			
			ca = new int[2];
			cb = new int[2];
			cb[0] = 9;
			cb[1] = 9;
			total = 0;
			
			st = new StringTokenizer(br.readLine());
			a[0] = 0;
			for (int j = 0; j<M; j++) {
				a[j+1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			b[0] = 0;
			for (int j = 0; j<M; j++) {
				b[j+1] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j<A;j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken())-1;
				int x = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				ap.add(new AP(x,y,c,p));
			}
			
			Collections.sort(ap);
			
			for (int j = 0; j<M+1; j++) {
				int aBit = 0;
				int bBit = 0;
				int f = 0;
				
				ca[0] += dx[a[j]];
				ca[1] += dy[a[j]];
				
				cb[0] += dx[b[j]];
				cb[1] += dy[b[j]];
				
				for (int k = 0; k<A; k++) {
					AP tmpAp = ap.get(k);
					
					
					if (Math.abs(ca[0]-tmpAp.x)+Math.abs(ca[1]-tmpAp.y) <= tmpAp.c && Integer.bitCount(aBit) < 2) {
						aBit |= 1<<k;
					}
					if (Math.abs(cb[0]-tmpAp.x)+Math.abs(cb[1]-tmpAp.y) <= tmpAp.c && Integer.bitCount(bBit) < 2) {
						bBit |= 1<<k;
					}
				}
				
				f = aBit | bBit;
				boolean isA = false;
				boolean isB = false;
				int cnt = 0;
				
				for (int k = 0; k<A; k++) {
					if ((f&(1<<k)) != 0) {
						if (Integer.bitCount(f) == 1) {
							total += ap.get(k).p;
							break;
						} else {
							if ((aBit & (1<<k)) != 0 && (bBit & (1<<k)) != 0 ) {
								total += ap.get(k).p;
								cnt++;
							} else if ((aBit & (1<<k)) != 0 && !isA){
								total += ap.get(k).p;
								isA = true;
								cnt++;
							} else if ((bBit & (1<<k)) != 0 && !isB){
								total += ap.get(k).p;
								isB = true;
								cnt++;
							}
							if (cnt == 2) {
								break;
							}
						}
					}
				}
			}
			
			
			
			sb.append("#").append(i).append(" ").append(total).append("\n");
		}
		System.out.println(sb);
	}
	
	

}
