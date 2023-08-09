package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	실패 : NPE
	-> tree를 초기화하는 과정에서 상위 노드부터 차례대로 입력받는 것이 아닌 중간 노드가 먼저 입력되는 듯?
 */

public class Main_11437 {
	static Node[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		tree = new Node[n + 1];

		tree[1] = new Node(0, 0);

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (tree[a] == null) {
				tree[a] = new Node(tree[b].depth + 1, b);
			}

			if (tree[b] == null) {
				tree[b] = new Node(tree[a].depth + 1, a);
			}
		}

		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(lca(a, b)).append("\n");
		}

		System.out.print(sb);
	}

	private static int lca(int a, int b) {
		if (a == b) {
			return a;
		}

		Node nodeA = tree[a];
		Node nodeB = tree[b];

		if (nodeA.depth == nodeB.depth) {
			return lca(nodeA.parent, nodeB.parent);
		}

		if (nodeA.depth > nodeB.depth) {
			return lca(nodeA.parent, b);
		}

		return lca(a, nodeB.parent);
	}

	static class Node {
		int depth;
		int parent;

		public Node(int depth, int parent) {
			this.depth = depth;
			this.parent = parent;
		}
	}
}
