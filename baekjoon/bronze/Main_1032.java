package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String str = input.readLine();
            if(sb.length() == 0) sb.append(str);
            else {
                for (int j = 0; j < str.length(); j++) {
                    if(str.charAt(j) != sb.charAt(j)) sb.setCharAt(j, '?');
                }
            }
        }
        System.out.println(sb);
    }
}
