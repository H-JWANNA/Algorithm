package silver;

import java.io.*;

public class Main_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        int[] dp = new int[num + 1];

        dp[0] = 0;
        dp[1] = 0;

        // dp[2] 부터 [n]까지 확인
        for (int i = 2; i <= num; i++) {
            // 1먼저 뺀 값과
            dp[i] = dp[i - 1] + 1;
            // 먼저 나눈 값 중 작은 값
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[num]);
    }
}
