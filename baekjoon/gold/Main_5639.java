package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5639 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int root = Integer.parseInt(br.readLine());
		Node rootNode = new Node(root);

		while (true) {
			int num;

			try {
				num = Integer.parseInt(br.readLine());
				rootNode.insert(num);
			} catch (Exception e) {
				break;
			}
		}

		postOrder(rootNode);
		System.out.println(sb);
	}

	static void postOrder(Node node) {
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.num).append("\n");
	}

	static class Node {
		int num;
		Node left;
		Node right;

		public Node(int num) {
			this.num = num;
		}

		public Node(int num, Node left, Node right) {
			this.num = num;
			this.left = left;
			this.right = right;
		}

		void insert(int n) {
			// 현재 num 보다 작은 수면 왼쪽 자식, 크면 오른쪽 자식
			if (n < this.num) {
				// 왼쪽 자식이 비었다면 넣고, 아니라면 한 번 더 내려가서 넣기
				if (this.left == null) {
					this.left = new Node(n);
				} else {
					this.left.insert(n);
				}
			} else {
				// 오른쪽 자식이 비었다면 넣고, 아니라면 한 번 더 내려가서 넣기
				if (this.right == null) {
					this.right = new Node(n);
				} else {
					this.right.insert(n);
				}
			}
		}
	}
}
