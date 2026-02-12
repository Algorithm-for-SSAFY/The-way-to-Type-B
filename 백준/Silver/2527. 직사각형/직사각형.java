import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			if(q1 < y2 || q2 < y1 || p1 < x2 || p2 < x1 ) {
				sb.append("d").append("\n");
			}
			else if((x1 == p2 && q1 == y2) ||(p1 == x2 && q1 == y2) || (p1 ==x2 && y1 ==q2) || (x1 == p2 && y1 == q2)) {
				sb.append("c").append("\n");
			}
			else if(q1 == y2 ||p1 == x2 || y1 ==q2 || x1 == p2) {
				sb.append("b").append("\n");
			}
			else {
				sb.append("a").append("\n");
			}
		}
		System.out.println(sb.toString());

	}
}