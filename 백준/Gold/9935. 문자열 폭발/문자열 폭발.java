import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String bomb = br.readLine();
        int bombLength = bomb.length();
        char[] arr = new char[1000000];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
        	char ch = str.charAt(i);
        	arr[index] = ch;
        	index++;
            if(index >= bomb.length()) {
            	boolean exists = true;
            	for(int j=0; j<bomb.length(); j++) {
            		if(bomb.charAt(j) != arr[index - bomb.length() + j]) {
            			exists = false;
            			break;
            		}
            	}
            	if(exists) {
            		index -= bomb.length();
            	}
            }
        }
        for(int i=0; i<index; i++) {
        	sb.append(arr[i]);
        }
        if (sb.length() == 0) {
            bw.write("FRULA\n");
        } else {
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
    }
}