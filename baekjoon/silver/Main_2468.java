package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 {
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int height = Integer.parseInt(st.nextToken());
				arr[i][j] = height;
				max = Math.max(max, height);
			}
		}

		int answer = 1;

		for (int h = 1; h < max; h++) {
			visited = new boolean[n][n];
			int count = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] > h && !visited[i][j]) {
						bfs(j, i, h);
						count++;
					} else {
						visited[i][j] = true;
					}
				}
			}

			answer = Math.max(answer, count);
		}

		System.out.println(answer);
	}

	private static void bfs(int x, int y, int height) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, y});
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (isOut(nx, ny) || visited[ny][nx] || arr[ny][nx] <= height) {
					continue;
				}

				q.add(new int[] {nx, ny});
				visited[ny][nx] = true;
			}
		}
	}

	private static boolean isOut(int x, int y) {
		return x < 0 || y < 0 || x >= arr[0].length || y >= arr.length;
	}
}
