package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14938 {
	static int INF = 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		/*
			n : 지역의 개수 (vertex)
			m : 수색 범위 (최대 가중치)
			r : 길의 개수 (edge)
		 */
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[] items = new int[n];
		int[][] map = new int[n][n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			items[i] = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				map[i][j] = INF;
			}
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			map[a - 1][b - 1] = l;
			map[b - 1][a - 1] = l;
		}

		// 경유 도시
		for (int t = 0; t < n; t++) {
			// 출발 도시
			for (int i = 0; i < n; i++) {
				// 도착 도시
				for (int j = 0; j < n; j++) {
					if (i == j) {
						continue;
					}

					int ij = map[i][j];
					int it = map[i][t];
					int tj = map[t][j];

					map[i][j] = Math.min(ij, it + tj);
				}
			}
		}

		int maxItem = 0;

		for (int i = 0; i < n; i++) {
			int curItem = 0;

			for (int j = 0; j < n; j++) {
				if (map[i][j] <= m) {
					curItem += items[j];
				}
			}

			maxItem = Math.max(maxItem, curItem);
		}

		System.out.println(maxItem);
	}
}
