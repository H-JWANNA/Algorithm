package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_25418 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[k + 1];

		System.out.print(bfs(a, k, visited));
	}

	// BFS
	private static int bfs(int a, int k, boolean[] visited) {
		Queue<int[]> q = new ArrayDeque<>();

		// int[0] = k가 되는 중인 a
		// int[1] = count
		q.add(new int[] {a, 0});

		while (!q.isEmpty()) {
			int[] current = q.poll();

			// 탈출 조건
			if (current[0] == k) {
				return current[1];
			}

			if (current[0] * 2 <= k) {
				visited[current[0] * 2] = true;
				q.add(new int[] {current[0] * 2, current[1] + 1});
			}

			if (!visited[current[0] + 1] && current[0] + 1 <= k) {
				visited[current[0] + 1] = true;
				q.add(new int[] {current[0] + 1, current[1] + 1});
			}
		}

		return -1;
	}
}
