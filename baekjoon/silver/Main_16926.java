package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926 {
	static int[][] arr;
	static int R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		/*
			테두리부터 안쪽으로 포인트를 옮기면서 회전시킨다.
			포인트를 옮기는 횟수는 min(N, M) / 2 이다.
			도는 횟수는 R을 현재 도는 테두리의 숫자 수만큼 나눈 나머지이다.
		 */

		shift(Math.min(N, M) / 2);

		// System.out.println(Arrays.deepToString(arr));

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}

	private static void shift(int num) {
		for (int point = 0; point < num; point++) {
			turn(point);
		}
	}

	private static void turn(int point) {
		int x = arr[0].length - 1 - point;
		int y = arr.length - 1 - point;
		int numbers = (x + y - point * 2) * 2;

		for (int r = 0; r < R % numbers; r++) {
			int temp = arr[point][point];
			// 상
			for (int j = point; j < x; j++) {
				arr[point][j] = arr[point][j + 1];
			}
			// 우
			for (int i = point; i < y; i++) {
				arr[i][x] = arr[i + 1][x];
			}
			// 하
			for (int j = x; j > point; j--) {
				arr[y][j] = arr[y][j - 1];
			}
			// 좌
			for (int i = y; i > point; i--) {
				arr[i][point] = arr[i - 1][point];
			}
			arr[point + 1][point] = temp;
		}
	}
}
