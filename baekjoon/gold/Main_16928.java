package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928 {
	static int[] map;
	static int[] counts;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[101];
		counts = new int[101];
		visited = new boolean[101];

		for (int i = 0; i <= 100; i++) {
			map[i] = i;
			counts[i] = 987654321;
		}

		counts[1] = 0;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			map[from] = to;
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			map[from] = to;
		}

		bfs(1);

		System.out.println(counts[100]);
	}

	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 1; i <= 6; i++) {
				int next = cur + i;

				if (next >= map.length) {
					continue;
				}

				// 사다리 탔는데 그 자리에서 뱀 밟을지도 모름
				int goal = next;
				while (goal != map[goal]) {
					goal = map[goal];
				}

				if (visited[next] || visited[goal]) {
					continue;
				}

				visited[next] = true;
				visited[goal] = true;
				q.add(map[next]);
				counts[map[next]] = Math.min(counts[map[next]], counts[cur] + 1);
			}
		}
	}
}
