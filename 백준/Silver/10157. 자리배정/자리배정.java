import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int area1 = Integer.parseInt(st.nextToken());
		int area2 = Integer.parseInt(st.nextToken());
		boolean[][] area = new boolean[area1][area2];
		int num = Integer.parseInt(br.readLine());
		// 입력 끝
		int[] dx = { 0, 1, 0, -1 };//오아왼위
		int[] dy = { 1, 0, -1, 0 };
		int idx = 0;
		int x = 0;
		int y = 0;
		int nx;
		int ny;
		boolean flag = false;
		for (int i = 1; i <= area1 * area2; i++) {
			area[x][y] = true;
			if (i == num) {
				flag = true;
				break;
			}
			nx = x + dx[idx];
			ny = y + dy[idx];

			if (nx < 0 || nx >= area1 || ny < 0 || ny >= area2) {
				idx = (++idx) % 4;
				nx = x + dx[idx];
				ny = y + dy[idx];
			}
			else if(area[nx][ny]) {
				idx = (++idx) % 4;
				nx = x + dx[idx];
				ny = y + dy[idx];
			}
			
			x = nx;
			y = ny;
		}
		if(flag) {
			sb.append(++x).append(" ").append(++y);
		}
		else {
			sb.append("0");
		}

		System.out.println(sb.toString());

	}
}