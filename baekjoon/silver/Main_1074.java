package silver;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // 결과값을 저장할 변수
        int result = 0;

        // 재귀
        System.out.println(z(n, x, y, result));
    }

    public static int z(int n, int x, int y, int result) {
        // n 이 1이 되면 마지막 결과를 구해야한다. (좌표 값에 따라) 0, 1, 2, 3 중에서 값이 있다.
        // 사분면으로 나누었을때 해당 사분면의 (0,0) 값은 [4^(n-1) * (0~3)]이다.
        // 재귀를 돌 때 해당 값을 result 에 추가하고 n을 1씩 감소시키면서 사분면을 계속 탐색한다.
        // 어떤 사분면에 위치하는지에 따라 좌표값도 계속 수정해준다.
        // 0 -> [x-2^(n-1)]

        // n == 0 일 때 ( 재귀 종료 조건 )
        if (n == 0) return result;

        // 해당 (x, y) 좌표의 사분면 구하고, (x, y) 좌표 수정하기
        // 구역을 구분하는 기준 half = 2^(n-1)
        int half = (int) Math.pow(2, n-1);
        int quadrant;

        if(x >= half && y >= half) {
            quadrant = 3;
            x -= half;
            y -= half;
        }
        else if(x < half && y >= half) {
            quadrant = 2;
            y -= half;
        }
        else if(x >= half && y < half) {
            quadrant = 1;
            x -= half;
        }
        else quadrant = 0;

        // 사분면에 따라 result 값 추가하기 [ 4^(n-1) * (0~3) ]
        int initNum = (int) Math.pow(4, n-1);
        result += (initNum * quadrant);

        // 재귀 호출 (n을 1씩 감소시키면서)
        return z(--n, x, y, result);
    }
}
