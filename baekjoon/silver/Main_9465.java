package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465 {
	static int[][] stickers;
	static int[][] dp;
	static int max;

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
			stickers = new int[2][n];
			dp = new int[2][n];
			max = 0;

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					int point = Integer.parseInt(st.nextToken());
					stickers[i][j] = point;
				}
			}

			init();

			// Bottom-up
			for (int i = 2; i < n; i++) {
				max = Math.max(max, sum(i));
			}

			System.out.println(max);
		}

	}

	private static int sum(int n) {
		dp[0][n] = Math.max(dp[1][n - 1] + stickers[0][n], dp[1][n - 2] + stickers[0][n]);
		dp[1][n] = Math.max(dp[0][n - 1] + stickers[1][n], dp[0][n - 2] + stickers[1][n]);

		return Math.max(dp[0][n], dp[1][n]);
	}

	private static void init() {
		/*
			== 초기값 설정 ==
			0번째 열에는 원래 값
			1번째 열에는 대각선 값의 합을 넣는다.
		 */
		for (int i = 0; i < 2; i++) {
			dp[i][0] = stickers[i][0];
			max = Math.max(max, dp[i][0]);

			if (dp[0].length > 1) {
				dp[i][1] = stickers[1 - i][0] + stickers[i][1];
				max = Math.max(max, dp[i][1]);
			}
		}
	}
}
