package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5525 {
    static String s;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        s = br.readLine();

        int len = 2 * n + 1;
        int end = m - len;

        int i = 0;

        while (i <= end) {
            int jump = search(i, len);
            i += jump;
        }

        System.out.println(count);
    }

    private static int search(int start, int len) {
        int sameLen = 0;
        int idx = 0;

        for (int i = start; i < s.length(); i++) {
            if (idx % 2 == 0) {
                if (s.charAt(i) == 'I') {
                    sameLen++;
                } else {
                    break;
                }
            }

            if (idx % 2 == 1) {
                if (s.charAt(i) == 'O') {
                    sameLen++;
                } else {
                    break;
                }
            }

            idx++;

            if (sameLen == len) {
                count++;
                break;
            }
        }

        if (sameLen == 0) {
            return 1;
        } else if (sameLen == 1) {
            return 1;
        } else if (sameLen % 2 == 1) {
            return 2;
        } else {
            return sameLen;
        }
    }
}
