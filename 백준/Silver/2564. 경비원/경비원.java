import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int width;
	static int height;

	public static int searchXY(int idx, int way, int leng) {
		if (way == 1) { // 북
			return leng;
		} else if (way == 2) { // 남
			return width + height + (width - leng);
		} else if (way == 3) { // 서
			return width * 2 + height + (height - leng);
		} else { // 동
			return width + leng;
		}
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken()); // 가로
		height = Integer.parseInt(st.nextToken()); // 세로
		int cir = width * 2 + height * 2; // 전체 둘레

		int num = Integer.parseInt(br.readLine()); // 상점 수
		int[] store = new int[num];
		int dongun;
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int way = Integer.parseInt(st.nextToken());
			int leng = Integer.parseInt(st.nextToken());
			store[i] = searchXY(i, way, leng);
		} // 상점
		st = new StringTokenizer(br.readLine());
		int way = Integer.parseInt(st.nextToken());
		int leng = Integer.parseInt(st.nextToken());
		dongun = searchXY(0, way, leng);// 동근
		// 입력 끝
		int res = 0;
		
		for(int i=0;i<num;i++) {
			int way1 = Math.abs(store[i]-dongun);
			int way2 = cir - way1;
			res += Math.min(way1, way2);
		}

		System.out.println(res);

	}
}