package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	메모리 : 42484 KB
	시간 : 416 ms
 */

public class Main_11404 {
	static int[][] costs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		costs = new int[n + 1][n + 1];

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			int curCost = costs[first][second];

			costs[first][second] = curCost == 0 ? cost : Math.min(curCost, cost);
		}

		/*
			costs 는 도시 간의 버스 비용으로 초기화되어 있다.
			특정 도시를 경유해서 갈 경우의 최소 비용과 한 번에 갈 경우의 최소 비용을 비교한다.
			모든 경우를 완전 탐색으로 탐색하면 도시 간의 비용이 최소가 된다.
			출발 도시, 도착 도시, 경유지 중 둘 이상이 같은 경우는 무시한다.
			특정 도시에 가는 비용이 0인 경우에는 갈 수 없는 경우이므로 경유해서 가는 경우를 입력한다.
		 */

		for (int t = 1; t <= n; t++) {    // 경유 도시

			for (int i = 1; i <= n; i++) {    // 출발 도시
				if (t == i || costs[i][t] == 0)
					continue;

				for (int j = 1; j <= n; j++) {    // 도착 도시
					if (i == j || t == j || costs[t][j] == 0)
						continue;

					int ij = costs[i][j];
					int it = costs[i][t];
					int tj = costs[t][j];

					if (ij == 0) {
						costs[i][j] = it + tj;
					} else {
						costs[i][j] = Math.min(ij, it + tj);
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(costs[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}
