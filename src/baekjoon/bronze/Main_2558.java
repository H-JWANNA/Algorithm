package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main_2558 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        for (int i = 0 ; i < 2; i++) {
            int num = Integer.parseInt(input.readLine());
            result += num;
        }

        System.out.println(result);
    }
}
