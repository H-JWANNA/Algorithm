package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main_2667 {
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		map = new boolean[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = line[j].equals("1");
			}
		}

		int complex = 0;
		ArrayList<Integer> counts = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j]) {
					int cnt = bfs(i, j);
					complex++;
					counts.add(cnt);
				}
			}
		}

		Collections.sort(counts);

		StringBuilder sb = new StringBuilder();

		sb.append(complex).append("\n");

		for (Integer count : counts) {
			sb.append(count).append("\n");
		}

		System.out.print(sb);
	}

	static int bfs(int x, int y) {
		int cnt = 0;

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, y});
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (isOutOfRange(nx, ny) || visited[nx][ny] || !map[nx][ny]) {
					continue;
				}

				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}

		return cnt;
	}

	static boolean isOutOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || ny >= map.length || nx >= map[ny].length;
	}
}
