
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>(); 
		
		int t = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int ch = Integer.parseInt(st.nextToken());
			
			if(stack.empty() || stack.peek() < ch) {
				if (ch !=0) stack.push(ch);
			} else if (stack.peek() > ch) {
				stack.pop();
				++cnt;
				
				while (!stack.empty() && stack.peek()>ch) {
					stack.pop();
					++cnt;
				}
				
				if((!stack.empty() && stack.peek().equals(ch)) || ch ==0) {
					continue;
				}
				
				stack.push(ch);
			} 
		}
		
		while(!stack.empty()) {
			stack.pop();
			++cnt;
		}
		
		System.out.println(cnt);
	}
}
