public class Daily_29 {
    public int tiling(int num) {

        int[] dp = new int[num + 1];

        // 초기값 설정
        dp[1] = 1;
        if(num > 1) dp[2] = 2;

        // return bottomUp(num, dp);
        return topDown(num, dp);
    }

    // Bottom-up
    public int bottomUp (int num, int[] dp) {
        for(int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[num];
    }

    // Top-down
    public int topDown (int num, int[] dp) {
        // 탈출 조건
        if (dp[num] != 0) return dp[num];

        dp[num] = topDown(num - 2, dp) + topDown(num - 1, dp);

        return dp[num];
    }
}
