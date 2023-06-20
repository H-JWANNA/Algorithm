package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10844 {
	static final int M = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][10];

		for (int j = 1; j < 10; j++) {
			dp[1][j] = 1;
		}

		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][1];
			dp[i][9] = dp[i - 1][8];

			for (int j = 1; j < 9; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % M;
			}
		}

		int sum = 0;
		for (int j = 0; j < 10; j++) {
			sum += dp[n][j];
			sum %= M;
		}

		System.out.println(sum);
	}
}
