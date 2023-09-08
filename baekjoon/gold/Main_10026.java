package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_10026 {

	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		char[][] map = new char[n][n];
		char[][] rgMap = new char[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				char c = s.charAt(j);
				map[i][j] = c;

				if (c == 'G') {
					rgMap[i][j] = 'R';
				} else {
					rgMap[i][j] = c;
				}
			}
		}

		int cnt = 0;
		int rgCnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(j, i, map);
					cnt++;
				}
			}
		}

		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(j, i, rgMap);
					rgCnt++;
				}
			}
		}

		System.out.println(cnt + " " + rgCnt);
	}

	static void bfs(int x, int y, char[][] map) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		char standard = map[y][x];

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, y});
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (isOutOfRange(ny, nx) || visited[ny][nx] || map[ny][nx] != standard) {
					continue;
				}

				q.add(new int[] {nx, ny});
				visited[ny][nx] = true;
			}
		}
	}

	private static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= visited.length || nx >= visited[ny].length;
	}
}
