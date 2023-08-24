package Lv2;

public class Solution_12914 {
	public long solution(int n) {
		long[] dp = new long[n + 1];

		// 초기화
		dp[1] = 1;
		if (n > 1) {
			dp[2] = 2;
		}

		// bottom-up
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
		}

		return dp[n];
	}
}
