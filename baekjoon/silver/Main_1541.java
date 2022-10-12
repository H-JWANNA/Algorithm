// 메모리 : 11544KB
// 시간 : 76ms

package silver;

import java.io.*;
import java.util.*;

public class Main_1541 {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] arr = input.readLine().split("-");

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(arr[i], "+");
            int sum = 0;
            while(st.hasMoreTokens()){
                sum += Integer.parseInt(st.nextToken());
            }
            arr[i] = Integer.toString(sum);
        }

        int result = Integer.parseInt(arr[0]);
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                result -= Integer.parseInt(arr[i]);
            }
        }

        System.out.println(result);
    }
}
