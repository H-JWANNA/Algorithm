package Lv2;

public class Solution_12945 {
    public int solution(int n) {
        long[] dp = new long[n + 1];

        dp[0] = 0L;
        dp[1] = 1L;

        for(int i = 2; i <= n; i++) {
            dp[i] = ( dp[i - 1] + dp[i - 2] ) % 1234567;
        }

        return (int) dp[n];
    }
}
