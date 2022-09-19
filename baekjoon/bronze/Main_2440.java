package baekjoon.bronze;

import java.io.*;

public class Main_2440 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(input.readLine());

        while (num != 0) {
            System.out.println("*".repeat(num));
            num -= 1;
        }
    }
}
