package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095_2 {
	static int[] dp = new int[12];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			init(n);

			// int answer = topDown(n);
			int answer = bottomUp(n);
			sb.append(answer).append("\n");
		}

		System.out.print(sb);
	}

	private static void init(int n) {
		dp[1] = 1;

		if (n > 2) {
			dp[3] = 4;
			dp[2] = 2;
		} else if (n > 1) {
			dp[2] = 2;
		}
	}

	private static int topDown(int n) {
		if (n < 4 || dp[n] != 0) {
			return dp[n];
		}

		dp[n] = topDown(n - 1) + topDown(n - 2) + topDown(n - 3);

		return dp[n];
	}

	private static int bottomUp(int n) {
		if (n < 4 || dp[n] != 0) {
			return dp[n];
		}

		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		return dp[n];
	}

	/*
	 * 1 -> 1
	 *
	 * 2 -> 1 + 1
	 * 		2
	 *
	 * 3 -> 1 + 1 + 1
	 *  	1 + 2
	 * 		2 + 1
	 *
	 * 4 -> 1 + 3
	 * 		2 + 2
	 * 		3 + 1
	 *
	 * 5 -> 1 + 4
	 * 		2 + 3
	 * 		3 + 2
	 * ...
	 */
}
