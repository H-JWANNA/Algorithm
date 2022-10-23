package silver;

import java.io.*;
import java.util.*;

public class Main_2630 {
    static int zero = 0;
    static int one = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(input.readLine());

        // 색종이 만들기
        paper = new int[n][n];

        // 색종이 칠하기
        for (int i = 0; i < n; i++) {   // row
            st = new StringTokenizer(input.readLine());

            for (int j = 0; j < n; j++) {   // column
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dividePaper(0, 0, n);
        System.out.println(zero);
        System.out.println(one);
    }

    public static void dividePaper(int row, int col, int num) {

        int standard = paper[row][col];

        if (isCount(row, col, num, standard)) {
            if (standard == 0) zero++;
            if (standard == 1) one++;
            return; // 탈출
        }
        num = num / 2;

        // 4개로 나누어 탐색
        dividePaper(row, col, num);
        dividePaper(row + num, col, num);
        dividePaper(row, col + num, num);
        dividePaper(row + num, col + num, num);
    }

    // 모두 같은 색인지 확인한다.
    public static boolean isCount(int row, int col, int num, int standard) {
        // 나눈 배열 순회
        for (int i = row; i < row + num; i++) {
            for (int j = col; j < col + num; j++) {
                if (paper[i][j] != standard) return false;
            }
        }

        return true;
    }
}
