package Lv2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Solution_86971 {
	static int answer = Integer.MAX_VALUE;
	static ArrayList<Integer>[] tree;

	public int solution(int n, int[][] wires) {
		init(n, wires);

		for (int[] wire : wires) {
			int a = wire[0];
			int b = wire[1];

			int aCount = getCount(a, b, n);
			int bCount = getCount(b, a, n);

			answer = Math.min(answer, Math.abs(aCount - bCount));
		}

		return answer;
	}

	public int getCount(int a, int ignore, int n) {
		int count = 0;

		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(a);
		visited[a] = true;

		while(!q.isEmpty()) {
			int cur = q.poll();

			for(int i = 0; i < tree[cur].size(); i++) {
				int next = tree[cur].get(i);

				if (next == ignore || visited[next]) {
					continue;
				}

				q.add(next);
				visited[next] = true;
				count++;
			}
		}

		return count;
	}

	public void init(int n, int[][] wires) {
		tree = new ArrayList[n + 1];

		for(int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int[] wire : wires) {
			int a = wire[0];
			int b = wire[1];

			tree[a].add(b);
			tree[b].add(a);
		}
	}
}
