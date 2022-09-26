package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        StringTokenizer st1 = new StringTokenizer(str, "1");
        StringTokenizer st0 = new StringTokenizer(str, "0");

        int num1 = st1.countTokens();
        int num0 = st0.countTokens();

        System.out.println(Math.min(num1,num0));
    }
}
