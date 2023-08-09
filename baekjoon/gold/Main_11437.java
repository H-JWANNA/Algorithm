package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
	메모리 : 46380 KB
	시간 : 3384 ms
 */

public class Main_11437 {
	static ArrayList<Integer>[] input;
	static Node[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		input = new ArrayList[n + 1];
		tree = new Node[n + 1];

		for (int i = 0; i <= n; i++) {
			input[i] = new ArrayList<>();
			tree[i] = new Node(0, 0);
		}

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			input[a].add(b);
			input[b].add(a);
		}

		makeTree(1);

		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(lca(a, b)).append("\n");
		}

		System.out.print(sb);
	}

	private static void makeTree(int node) {
		for (Integer i : input[node]) {
			if (i == tree[node].parent) {
				continue;
			}

			tree[i].parent = node;
			tree[i].depth = tree[node].depth + 1;

			makeTree(i);
		}
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
