package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724_2 {
	static boolean[][] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 정점
		int m = Integer.parseInt(st.nextToken());	// 간선

		adjList = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			adjList[first][second] = true;
			adjList[second][first] = true;
		}

		int count = 0;

		// 모든 정점 탐색
		for (int i = 1; i <= n; i++) {
			if (visited[i]) continue;

			// 연결된 요소가 끝나면 count 증가
			search(i);
			count++;
		}

		System.out.println(count);
	}

	private static void search(int x) {
		visited[x] = true;

		for (int i = 1; i < visited.length; i++) {
			if (!visited[i] && adjList[x][i]) {
				search(i);
			}
		}
	}
}
