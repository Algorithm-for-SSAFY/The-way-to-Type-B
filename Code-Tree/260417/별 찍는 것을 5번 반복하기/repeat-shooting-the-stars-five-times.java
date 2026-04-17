import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		*/
		
		print();
		
	}
	
	public static void print() {
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<10; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
