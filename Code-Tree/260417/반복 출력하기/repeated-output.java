import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		print(n);
		
	}
	
	public static void print(int n) {
		for (int i = 0; i<n; i++) {
			System.out.println("12345^&*()_");
		}
	}

}
