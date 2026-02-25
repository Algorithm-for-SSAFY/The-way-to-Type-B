import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<String> seq = new ArrayList<>();
	static int res = 0;
	static int L;
	static int C;
	static List<String> ps = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void dfsS(int start) {
		// start가 암호길이 L과 같은 길이가 됐을 때
		if (ps.size() == L) {
			int vow = 0;
			int cons = 0;
			// 자음과 모음이 필요갯수만큼 존재한다면
			for (String password : ps) {
				if ("aeiou".contains(password)) {
					vow++;// 모음++
				} else {
					cons++; // 자음++
				}
			}
			if(vow>=1 && cons>=2) {
				for(String password : ps) {
					sb.append(password);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=start;i<C;i++) {
			ps.add(seq.get(i));
			dfsS(i+1);
			ps.remove(ps.size()-1);
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());// 암호 길이
		C = Integer.parseInt(st.nextToken());// 가능 문자 갯수

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			seq.add(st.nextToken());
		}
		seq.sort(null);// 사전 순이니 정렬

		dfsS(0);

		System.out.println(sb);
	}
}