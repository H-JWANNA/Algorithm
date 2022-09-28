package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(input.readLine());
        int cnt = 0;

        for (int i = 1; i <= num; i++) {
            if (i % 125 == 0) cnt += 3;
            else if (i % 25 == 0) cnt += 2;
            else if (i % 5 == 0) cnt += 1;
        }

        System.out.println(cnt);
    }
}
