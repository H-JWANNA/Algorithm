// Bottom-Up :
// 메모리 : 11592KB
// 시간 : 76ms

// Top-Down :
// 메모리 : 11640KB
// 시간 : 76ms

package silver;

import java.io.*;

public class Main_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        int[] arr = new int[n + 1];
        Integer[] sum = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }

        // 초기값 설정
        sum[0] = arr[0];
        sum[1] = arr[1];
        if (n >= 2) {    // n이 1일 경우 예외처리
            sum[2] = arr[1] + arr[2];
        }

        // Bottom-Up ======================================
/*
        // sum[n] 을 구한다
        for (int i = 3; i <= n; i++) {
            sum[i] = Math.max( sum[i - 2], sum[i - 3] + arr[i - 1] ) + arr[i];
            // arr[n - 1]을 더하는 이유는
            // 만약 sum[5]가 arr[5] + sum[4]인 경우
            // sum[4]가 sum[3] + sum[2]의 값이라면 연속 3계단을 밟는 것이므로
            // sum[5]의 경우의 수는 sum[5] + sum[3]과 sum[5] + arr[4] + sum[2]가 되어야 연속 3계단을 밟는 것을 방지할 수 있다.
        }

        System.out.println(sum[n]);*/

        System.out.println(dp(n, arr, sum));
    }

    // Top-Down ======================================
    public static int dp(int n, int[] arr, Integer[] sum) {
        if (sum[n] == null) {
            sum[n] = Math.max(dp(n - 2, arr, sum), dp(n - 3, arr, sum) + arr[n - 1]) + arr[n];
        }

        return sum[n];
    }
}

