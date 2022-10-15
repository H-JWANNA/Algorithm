// 메모리 : 11616KB
// 시간 : 76ms

package silver;

import java.io.*;

public class Main_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(input.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(input.readLine());

            output.write(Long.toString(dp(n)));
            output.newLine();
        }

        output.flush();
        output.close();
    }

    public static Long dp(int n) {
        long[] arr = new long[n + 1];

        // 초기 조건
        arr[1] = 1;
        if (n > 1) arr[2] = 1;
        if (n > 2) arr[3] = 1;
        if (n > 3) arr[4] = 2;
        if (n > 4) arr[5] = 2;

        // Bottom-Up
        for (int i = 6; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }

        return arr[n];
    }
}
