package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		boolean[][] graph = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				graph[i][j] = st.nextToken().equals("1");
			}
		}

		// ===== 플로이드 와샬 =====

		for (int t = 0; t < n; t++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (graph[i][t] & graph[t][j]) {
						graph[i][j] = true;
					}
				}
			}
		}

		// ===== 출력 =====

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(graph[i][j] ? 1 : 0).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}
