package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            System.out.println(" ".repeat(i) + "*".repeat((2*(num-i))-1));
        }
        for (int i = 1; i <= num; i++) {
            if (i == 1) continue;
            System.out.println(" ".repeat(num-i) + "*".repeat(2*i -1));
        }
    }
}
