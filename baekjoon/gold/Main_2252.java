package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252 {
	static int[] edge;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		edge = new int[n + 1];
		graph = new ArrayList[n + 1];

		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			edge[b]++;
			graph[a].add(b);
		}

		System.out.println(topologicalSort());
	}

	private static String topologicalSort() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new ArrayDeque<>();

		// 차수가 0인 값 넣기
		for (int i = 1; i < edge.length; i++) {
			if (edge[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int curNode = q.poll();
			sb.append(curNode).append(" ");

			// 인접 노드의 차수를 감소시키고, 차수가 0이 된 값 넣기
			for (Integer nextNode : graph[curNode]) {
				edge[nextNode]--;

				if (edge[nextNode] == 0) {
					q.offer(nextNode);
				}
			}
		}

		return sb.toString();
	}
}
