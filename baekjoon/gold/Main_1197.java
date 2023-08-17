package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1197 {
	static ArrayList<Node> graph;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		parents = new int[v + 1];

		for (int i = 0; i <= v; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			Node node = new Node(a, b, cost);
			graph.add(node);
		}

		Collections.sort(graph);

		long answer = 0;

		for (Node node : graph) {
			if (v == 1) {
				break;
			}

			int x = find(node.a);
			int y = find(node.b);

			if (x == y) {
				continue;
			}

			change(x, y);
			answer += node.cost;
			v--;
		}

		System.out.println(answer);
	}

	static int find(int node) {
		if (parents[node] == node) {
			return node;
		}

		parents[node] = find(parents[node]);

		return parents[node];
	}

	static void change(int x, int y) {
		if (x < y) {
			parents[y] = x;
		} else {
			parents[x] = y;
		}
	}

	static class Node implements Comparable<Node> {
		int a;
		int b;
		int cost;

		public Node(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
