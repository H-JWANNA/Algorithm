package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2293 {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coins = new int[n];
		dp = new int[n][k + 1];

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(coins);

		// 초기값
		for (int i = 1; i <= k; i++) {
			dp[0][i] = i % coins[0] == 0 ? 1 : 0;
		}

		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}

		for (int j = 1; j <= k; j++) {
			for (int i = 1; i < n; i++) {
				if (j >= coins[i]) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		// System.out.println(Arrays.deepToString(dp));
		System.out.println(dp[n - 1][k]);
	}
}
