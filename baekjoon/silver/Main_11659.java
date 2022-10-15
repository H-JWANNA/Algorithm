// 메모리 : 55904KB
// 시간 : 616ms

package silver;

import java.io.*;
import java.util.*;

public class Main_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1부터의 구간합을 저장하는 배열
        int[] arr = new int[n  + 1];

        st = new StringTokenizer(input.readLine(), " ");
        // 구간합 배열 입력 (n 까지의 합은 n-1 까지의 합 + n 이다)
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // from ~ to 구간합은 arr[to]의 구간합에서 arr[from - 1]의 구간합을 뺀 값과 같다.
            int result = arr[to] - arr[from - 1];

            output.write(Integer.toString(result));
            output.newLine();
        }

        output.flush();
        output.close();
    }
}
