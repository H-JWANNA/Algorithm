package silver;

import java.io.*;

public class Main_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(input.readLine());

        int[][] dp = new int[41][2];
        // 0일 때, 0값 1개
        dp[0][0] = 1;
        // 1일 때, 1값 1개
        dp[1][1] = 1;

        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(input.readLine());

            // 피보나치 수열 Bottom-Up
            for (int j = 2; j <= num; j++) {
                dp[j][0] = dp[j - 2][0] + dp[j - 1][0];
                dp[j][1] = dp[j - 2][1] + dp[j - 1][1];
            }
            bw.write(dp[num][0] + " " + dp[num][1]);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
