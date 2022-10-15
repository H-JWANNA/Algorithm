// 메모리 : 11548KB
// 시간 : 76ms

package silver;

import java.io.*;

public class Main_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        input.close();

        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[1] = 1;
        if (n > 1) dp[2] = 2;

        // Bottom-up
        for (int i = 3; i <= n; i++) {
            dp[i] = ( dp[i - 2] + dp[i - 1] ) % 10007;
        }

        System.out.println(dp[n]);
    }
}
