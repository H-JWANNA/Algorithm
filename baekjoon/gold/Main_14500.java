package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500 {
	static int[][] paper;
	static boolean[][] visited;
	static int[] dn = {-1, 1, 0, 0};
	static int[] dm = {0, 0, -1, 1};

	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		paper = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, paper[i][j], 1);
				visited[i][j] = false;
			}
		}

		System.out.println(answer);
	}

	public static void dfs(int n, int m, int sum, int depth) {
		if (depth == 4) {
			answer = Math.max(answer, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int next_n = n + dn[i];
			int next_m = m + dm[i];

			if (isOutOfRange(next_n, next_m) || visited[next_n][next_m]) {
				continue;
			}

			if (depth == 2) {
				visited[next_n][next_m] = true;
				dfs(n, m, sum + paper[next_n][next_m], depth + 1);
				visited[next_n][next_m] = false;
			}

			visited[next_n][next_m] = true;
			dfs(next_n, next_m, sum + paper[next_n][next_m], depth + 1);
			visited[next_n][next_m] = false;
		}
	}

	private static boolean isOutOfRange(int n, int m) {
		return n < 0 || m < 0 || n >= paper.length || m >= paper[n].length;
	}
}
