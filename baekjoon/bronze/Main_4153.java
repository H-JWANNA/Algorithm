package bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			// 입력
			int[] tr = new int[3];
			tr[0] = Integer.parseInt(st.nextToken());
			tr[1] = Integer.parseInt(st.nextToken());
			tr[2] = Integer.parseInt(st.nextToken());

			// 탈출 조건 (0 0 0 이 입력되면 종료)
			if (tr[0] == 0 && tr[1] == 0 && tr[2] == 0) {
				break;
			}

			// 가장 긴 변의 제곱이 나머지 두 변의 제곱의 합과 같으면 직각 삼각형이다.
			Arrays.sort(tr);

			System.out.println(
				Math.pow(tr[2], 2) == (Math.pow(tr[0], 2) + Math.pow(tr[1], 2))
					? "right" : "wrong");
		}
	}
}
