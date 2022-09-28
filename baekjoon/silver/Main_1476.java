package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        // 1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int e = 1;
        int s = 1;
        int m = 1;
        int year = 1;

        while(true) {
            if(e > 15) e = 1;
            if(s > 28) s = 1;
            if(m > 19) m = 1;
            if(e == E && s == S && m == M) break;
            e++;
            s++;
            m++;
            year++;
        }

        System.out.println(year);
    }
}
