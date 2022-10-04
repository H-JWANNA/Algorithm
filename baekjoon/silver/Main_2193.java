package silver;

import java.io.*;

public class Main_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        // num+1 자리수 까지의 정답을 담을 배열 생성
        long[] dp = new long[num + 1];

        // 기본값 설정
        dp[0] = 0;
        dp[1] = 1;

        // 0으로 끝나는 n자리 수가 나올 경우의 수는 dp[n-1]
        // 1로 끝나는 n자리 수가 나올 경우의 수는 dp[n-2]
        // Bottom-Up 방식
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[num]);
    }
}
