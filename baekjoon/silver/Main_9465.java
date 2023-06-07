package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465 {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		/*
			2 x 3 스티커가 있을 때,
				a b c
				d e f

			c를 포함한 경우의 수는 다음과 같다.
			 => (a + e + c) / (d + c)

			따라서, 앞에서 대각선으로 계산한 값과 한 칸 너머 대각선 값 중 큰 값에 c를 더한다.
		*/

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			dp = new int[2][n];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// edge case
			if (n == 1) {
				System.out.println(Math.max(dp[0][0], dp[1][0]));
				continue;
			}

			init();

			// Bottom-up
			for (int x = 2; x < n; x++) {
				for (int y = 0; y < 2; y++) {
					sum(y, x);
				}
			}

			System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
		}

	}

	private static void sum(int y, int x) {
		dp[y][x] = Math.max(
			dp[1 - y][x - 1] + dp[y][x],
			dp[1 - y][x - 2] + dp[y][x]
		);
	}

	private static void init() {
		// 1번째 열에는 대각선 합을 넣는다.
		for (int y = 0; y < 2; y++) {
			dp[y][1] = dp[1 - y][0] + dp[y][1];
		}
	}
}
