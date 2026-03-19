import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		int num;
		Node left;
		Node right;
		public Node(int num) {
			this.num = num;
		}
		public void insert(Node node) {
			if(this.num > node.num) {
				if(left == null) {
					left = node;
				} else {
					left.insert(node);
				}
			} else {
				if(right == null) {
					right = node;
				} else {
					right.insert(node);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int rootNum = Integer.parseInt(br.readLine());
		Node root = new Node(rootNum);
		while(true) {
			String str = br.readLine();
			if(str == null || str.equals("")) {
				break;
			}
			int num = Integer.parseInt(str);
			Node node = new Node(num);
			root.insert(node);
		}
		StringBuilder sb = new StringBuilder();
		postOrder(root, sb);
		bw.write(sb.toString());
		bw.flush();
	}
	public static void postOrder(Node node, StringBuilder sb) {
		if(node.left != null) {
			postOrder(node.left, sb);
		}
		if(node.right != null) {
			postOrder(node.right, sb);
		}
		sb.append(node.num + "\n");
	}
}
