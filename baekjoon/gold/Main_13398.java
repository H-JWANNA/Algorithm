package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13398 {
    static int[] arr;
    static int[] dp;
    static int[] delDp;
    static int del = 0;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        delDp = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        delDp[0] = dp[0];
        max = dp[0];

        // 연속합 구하기
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }

        // 숫자를 하나 제거한 연속합 구하기
        for (int i = 1; i < n; i++) {
            if (arr[i] <= del) { // 여기 < 를 <=로 바꿔서 해결
                int before = del;
                del = arr[i];
                delDp[i] = Math.max(delDp[i - 1] + arr[i] - del + before, dp[i - 1]);
            } else {
                delDp[i] = Math.max(delDp[i - 1] + arr[i], arr[i]);
            }
            max = Math.max(max, delDp[i]);
        }

        System.out.println(max);
    }
}
