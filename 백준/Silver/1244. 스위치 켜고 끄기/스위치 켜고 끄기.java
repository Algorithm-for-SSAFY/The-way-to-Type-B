import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] LED;

	public static void womanChange(int nL, int nR, int LEDNum) {
		if (nL <= 0 || nR > LEDNum ) {
			// 1.범위 외이거나
			return;
		}
		if (LED[nL] != LED[nR]) {
			// 2. 둘이 같지 않으면
			return;
		}

		if (LED[nL] == 1) {
			LED[nL] = 0;
			LED[nR] = 0;
		} else {
			LED[nL] = 1;
			LED[nR] = 1;
		} // 상태 바꾸기
		nL -= 1;
		nR += 1;
		womanChange(nL, nR, LEDNum);
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int L = Integer.parseInt(br.readLine()); // LED개수
		LED = new int[L + 1];// 1부터 시작하는 LED

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= L; i++) {
			LED[i] = Integer.parseInt(st.nextToken());
		}
		int S = Integer.parseInt(br.readLine()); // student수
		for (int s = 0; s < S; s++) {
			st = new StringTokenizer(br.readLine());
			int mw = Integer.parseInt(st.nextToken());// 여?남?
			int num = Integer.parseInt(st.nextToken());// 숫자
			// 입력 끝

			// 학생 수만큼 LED를 조정
			if (mw == 1) {// 남자
				int numPs = 0;
				for (int i = 1; numPs <= L; i++) {
					numPs = numPs +num;
					if (numPs <= L && numPs %num==0) {// num의 배수가 L이거나 L보다 작을 때
						if (LED[numPs] == 1) {
							LED[numPs] = 0;
						} else {
							LED[numPs] = 1;
						} // 상태 바꾸기

					}
				}
			} // 남자끝
			else {// 여자
				if (LED[num] == 1) {
					LED[num] = 0;
				} else {
					LED[num] = 1;
				} // 상태 바꾸기
				
				int nL = num - 1;
				int nR = num + 1;
				womanChange(nL, nR, L);
			}
		} // 탐색 끝

		for (int i = 1; i <= L; i++) {
			sb.append(LED[i]).append(" ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}

}
