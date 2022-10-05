package silver;

import java.io.*;
import java.util.*;

public class Main_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(input.readLine());

        // 공집합 S 생성
        int[] s = new int[21];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            String method = st.nextToken();

            switch (method) {
                case "add":
                    s[Integer.parseInt(st.nextToken())] = 1;
                    break;
                case "remove":
                    s[Integer.parseInt(st.nextToken())] = 0;
                    break;
                case "check":
                    if(s[Integer.parseInt(st.nextToken())] == 1) {
                        bw.write("1");
                        bw.newLine();
                    }
                    else {
                        bw.write("0");
                        bw.newLine();
                    }
                    break;
                case "toggle":
                    int toggleNum = Integer.parseInt(st.nextToken());
                    s[toggleNum] = s[toggleNum] == 1 ? 0 : 1;
                    break;
                case "all":
                    for (int j = 1; j < s.length; j++) {
                        s[j] = 1;
                    }
                    break;
                case "empty":
                    s = new int[21];
                    break;
            }
        }
        input.close();
        bw.flush();
        bw.close();
    }
}
