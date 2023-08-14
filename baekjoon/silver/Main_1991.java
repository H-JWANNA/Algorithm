package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1991 {
	static Node[] tree;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		tree = new Node[n];
		sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			makeNode(s);
		}
		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);

		System.out.println(sb);
	}

	static void preorder(int node) {
		Node curNode = tree[node];

		sb.append((char)(node + 'A'));

		if (curNode.left >= 0) {
			preorder(curNode.left);
		}

		if (curNode.right >= 0) {
			preorder(curNode.right);
		}
	}

	static void inorder(int node) {
		Node curNode = tree[node];

		if (curNode.left >= 0) {
			inorder(curNode.left);
		}

		sb.append((char)(node + 'A'));

		if (curNode.right >= 0) {
			inorder(curNode.right);
		}
	}

	static void postorder(int node) {
		Node curNode = tree[node];

		if (curNode.left >= 0) {
			postorder(curNode.left);
		}

		if (curNode.right >= 0) {
			postorder(curNode.right);
		}

		sb.append((char)(node + 'A'));
	}

	static void makeNode(String s) {
		int parent = s.charAt(0) - 'A';
		int left = s.charAt(2) - 'A';
		int right = s.charAt(4) - 'A';

		tree[parent] = new Node(left < 0 ? -1 : left, right < 0 ? -1 : right);
	}

	static class Node {
		int left;
		int right;

		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
}
