package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

		System.out.println(Arrays.deepToString(arr));
	}

	private static void shift(int num) {
		int point = 0;

		while (num-- > 0) {
			turn(point);
			point++;
		}
	}

	private static void turn(int point) {
		int x = arr[0].length - 1 - point;
		int y = arr.length - 1 - point;
		int numbers = x * 2 + y * 2 + 2;

		for (int r = 0; r < R % numbers; r++) {
			int[][] turnedArr = copy(arr);

			for (int i = point; i <= y; i++) {
				for (int j = point; j <= x; j++) {
					// 상
					if (i == point && j > point) {
						turnedArr[i][j - 1] = arr[i][j];
					}
					// 좌
					else if (j == point && i < y) {
						turnedArr[i + 1][j] = arr[i][j];
					}
					// 하
					else if (i == y && j < x) {
						turnedArr[i][j + 1] = arr[i][j];
					}
					// 우
					else if (j == x && i > point) {
						turnedArr[i - 1][j] = arr[i][j];
					}
				}
			}

			arr = turnedArr;
		}
	}

	public static int[][] copy(int[][] src) {
		if (src == null) {
			return null;
		}

		return Arrays.stream(src)
			.map(int[]::clone)
			.toArray(int[][]::new);
	}
}
