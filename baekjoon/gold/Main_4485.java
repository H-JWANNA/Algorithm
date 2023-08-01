package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485 {
	static int INF = Integer.MAX_VALUE;
	static int[][] cave;
	static int[][] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}

			cave = new int[n][n];
			sum = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					sum[i][j] = INF;
				}
			}

			sb.append("Problem ")
				.append(t)
				.append(": ")
				.append(dijkstra(n))
				.append("\n");

			t++;
		}

		System.out.print(sb);
	}

	private static int dijkstra(int n) {
		sum[0][0] = cave[0][0];

		boolean[][] visited = new boolean[n][n];

		PriorityQueue<Thief> pq = new PriorityQueue<>();
		pq.add(new Thief(0, 0, cave[0][0]));
		visited[0][0] = true;

		int[] dx = new int[] {-1, 1, 0, 0};
		int[] dy = new int[] {0, 0, -1, 1};

		while (!pq.isEmpty()) {
			Thief thief = pq.poll();

			for (int i = 0; i < 4; i++) {
				int nx = thief.x + dx[i];
				int ny = thief.y + dy[i];

				if (nx >= n || ny >= n || nx < 0 || ny < 0) {
					continue;
				}

				if (visited[ny][nx]) {
					continue;
				}

				if (sum[ny][nx] > cave[ny][nx] + thief.rupee) {
					sum[ny][nx] = cave[ny][nx] + thief.rupee;
					visited[ny][nx] = true;
					pq.add(new Thief(nx, ny, sum[ny][nx]));
				}
			}
		}

		return sum[n - 1][n - 1];
	}

	static class Thief implements Comparable<Thief> {
		int x;
		int y;
		int rupee;

		public Thief(int x, int y, int rupee) {
			this.x = x;
			this.y = y;
			this.rupee = rupee;
		}

		@Override
		public int compareTo(Thief o) {
			return Integer.compare(this.rupee, o.rupee);
		}
	}
}
