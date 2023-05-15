package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {
	static int[][] tomatoes;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());    // 가로
		int n = Integer.parseInt(st.nextToken());    // 세로

		tomatoes = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				tomatoes[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		/*
			1. 배열을 완전 탐색으로 돌면서 익은 토마토를 찾는다.
			2. 그래프 탐색을 통해 익은 토마토 주변의 0인 토마토를 익은 토마토 +1로 만든다.
			3. 모든 사이클을 다 돌았다면 0이 존재하는지 확인한다.
			4. 0이 있다면 -1, 0이 없다면 가장 큰 값을 찾는다.
		 */

		bfs();

		int date = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tomatoes[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}

				date = Math.max(date, tomatoes[i][j]);
			}
		}

		System.out.println(date - 1);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < tomatoes.length; i++) {
			for (int j = 0; j < tomatoes[i].length; j++) {
				if (tomatoes[i][j] == 1) {
					q.add(new int[] {j, i});
				}
			}
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];

			for (int i = 0; i < 4; i++) {
				int next_x = cur_x + dx[i];
				int next_y = cur_y + dy[i];

				if (isWithin(next_x, next_y) && tomatoes[next_y][next_x] == 0) {
					q.add(new int[] {next_x, next_y});
					tomatoes[next_y][next_x] = tomatoes[cur_y][cur_x] + 1;
				}
			}
		}
	}

	private static boolean isWithin(int x, int y) {
		return y >= 0 && x >= 0 && y < tomatoes.length && x < tomatoes[0].length;
	}
}
