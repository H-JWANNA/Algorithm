package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18111 {
    static int b;
    static int[][] grounds;
    static int[] answers = new int[257];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        grounds = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grounds[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
            땅의 높이는 0 ~ 256이므로
            현재 땅을 0 ~ 256으로 만들면서 최소값을 구한다.
            만약 블럭이 없다면 그만 쌓아올린다.
            최소 값이 여러개라면 높은 땅을 출력해야하므로, 작거나 같을 때 값을 갱신한다.
         */

        for (int i = 0; i <= 256; i++) {
            answers[i] = toFlat(i);

            if (answers[i] == -1) {
                break;
            }
        }

        int time = Integer.MAX_VALUE;
        int height = -1;

        for (int i = 0; i <= 256; i++) {
            if (answers[i] == -1) {
                break;
            }

            if (time >= answers[i]) {
                time = answers[i];
                height = i;
            }
        }

        System.out.println(time + " " + height);
    }

    private static int toFlat(int height) {
        int time = 0;
        int block = b;

        for (int[] ground : grounds) {
            for (int y : ground) {
                if (y > height) {
                    time += (y - height) * 2;
                    block += (y - height);
                }
            }
        }

        for (int[] ground : grounds) {
            for (int y : ground) {
                if (y < height) {
                    time += (height - y);
                    block -= (height - y);
                }

                if (block < 0) {
                    return -1;
                }
            }
        }

        return time;
    }
}
