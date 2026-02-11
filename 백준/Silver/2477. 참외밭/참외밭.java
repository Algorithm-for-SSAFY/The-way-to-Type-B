import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[][] area = new int[6][2];
		int maxArea = 0;
		int maxIdx = 0;
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			area[i][0] = Integer.parseInt(st.nextToken());
			area[i][1] = Integer.parseInt(st.nextToken());
			if (area[i][1] > maxArea) {
				maxArea = area[i][1];
				maxIdx = i;
			}
		} // 입력
		//maxIdx <- 1. 가장 큰 거 찾아서
		int res = 0;
		int idxP = maxIdx+1;
		int idxM = maxIdx-1;
		
		if(idxP > 5) {
			idxP = 0;
		}
		else if(idxM < 0) {
			idxM = 5;
		}
		int tmp1 = Math.min(area[idxP][1],area[idxM][1]); //1. 작은 걸 고른다
		int tmp2 = Math.max(area[idxP][1],area[idxM][1]); //2. 큰 걸 골라서
		
		tmp2 = tmp2 - tmp1;//2. 작은 걸 뺀다
		tmp1 = tmp1 * area[maxIdx][1]; //1. 작은 거랑 가장 큰 거 곱하기

		int idx = area[idxP][1]> area[idxM][1] ? idxP : idxM; //2.큰 거 인덱스 찾아서
		
		idxP = idx+1;
		idxM = idx-1;
		
		if(idxP > 5) {
			idxP = 0;
		}
		else if(idxM < 0) {
			idxM = 5;
		}
		tmp2 = tmp2 * Math.min(area[idxP][1], area[idxM][1]);
		
		res = (tmp1+tmp2)*K;
		System.out.println(res);
				

	}
}