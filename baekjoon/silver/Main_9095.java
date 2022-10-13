// 메모리 : 11460KB
// 시간 : 76ms

package silver;

import java.io.*;

public class Main_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(input.readLine());
            int[] dp = new int[num + 1];

            // 초기값 설정
            dp[1] = 1;
            if (num > 1) dp[2] = 2;
            if (num > 2) dp[3] = 4;

            // Bottom-up ===============
            for (int n = 4; n <= num; n++) {
                // dp[4]는 dp[3]에 1을 더한 경우 + dp[2]에 2를 더한 경우 + dp[1]에 1을 더한 경우이다.
                // 따라서, dp[n] = dp[n-1] + dp[n-2] + dp[n-3] 이다.
                dp[n] = dp[n-1] + dp[n-2] + dp[n-3];
            }

            System.out.println(dp[num]);
        }
    }
}
