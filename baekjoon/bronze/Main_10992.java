package bronze;

import java.io.*;

public class Main_10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        for (int i = 0; i < num - 1; i++) {
            if(i == 0) {
                for (int j = 0; j < (num - i - 1); j++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
            else {
                for (int j = 0; j < (num - i - 1); j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                for (int k = 0; k < (i * 2 - 1); k++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
        }
        for (int k = 0; k < (num * 2 - 1); k++) {
            System.out.print("*");
        }
    }
}
