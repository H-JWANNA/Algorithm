package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940 {
	static int[][] arr;
	static boolean[][] visited;
	static int[] goal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int ground = Integer.parseInt(st.nextToken());
				if (ground == 2) {
					goal = new int[] {i, j, 0};
				}
				arr[i][j] = ground;
			}
		}

		bfs();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && arr[i][j] != 0) {
					sb.append(-1).append(" ");
				} else {
					sb.append(arr[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(goal);
		visited[goal[0]][goal[1]] = true;

		int[] dx = new int[] {-1, 1, 0, 0};
		int[] dy = new int[] {0, 0, -1, 1};

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[1];
			int y = cur[0];
			int count = cur[2];
			arr[y][x] = count;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (cantGo(nx, ny))
					continue;

				if (visited[ny][nx])
					continue;

				if (arr[ny][nx] == 0) {
					visited[ny][nx] = true;
					continue;
				}

				q.add(new int[] {ny, nx, count + 1});
				visited[ny][nx] = true;
			}
		}
	}

	private static boolean cantGo(int x, int y) {
		return x < 0 || y < 0 || x >= arr[0].length || y >= arr.length;
	}
}
