import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (sb.length() >= bombLen) {
                boolean isMatch = true;
                for (int j = 0; j < bombLen; j++) {
                    if (sb.charAt(sb.length() - bombLen + j) != bomb.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    sb.setLength(sb.length() - bombLen);
                }
            }
        }
        if (sb.length() == 0) {
            bw.write("FRULA\n");
        } else {
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
    }
}