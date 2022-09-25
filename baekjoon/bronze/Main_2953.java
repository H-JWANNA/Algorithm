package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2953 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        int max = 0;

        for (int i = 1; i <= 5; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int sum = 0;
            while (st.hasMoreTokens()) {
                sum += Integer.parseInt(st.nextToken());
            }

            if (sum > max) {
                max = sum;
                num = i;
            }
        }
        System.out.println(num + " " + max);
    }
}
