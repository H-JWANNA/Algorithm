package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = init(n);
		int answer = topDown(dp, n);
		// int answer = bottomUp(dp, n);

		System.out.println(answer % 10007);
	}

	private static int[] init(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;

		if (n > 1) {
			dp[2] = 2;
		}

		return dp;
	}

	private static int topDown(int[] dp, int n) {
		// 탈출 조건
		if (n < 3 || dp[n] != 0) {
			return dp[n];
		}

		dp[n] = (topDown(dp, n - 1) + topDown(dp, n - 2)) % 10007;

		return dp[n];
	}

	private static int bottomUp(int[] dp, int n) {
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}

		return dp[n];
	}
}
