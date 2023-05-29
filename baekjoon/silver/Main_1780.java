package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780 {
	static int[][] arr;
	static int[] answer = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, n);

		for (int i : answer) {
			System.out.println(i);
		}
	}

	private static void divide(int startRow, int startCol, int size) {
		// 탈출 조건
		if (size == 1) {
			count(arr[startRow][startCol]);
			return;
		}

		if (isSame(startRow, startCol, size)) {
			count(arr[startRow][startCol]);
		} else {
			int nextSize = size / 3;
			divide(startRow, startCol, nextSize);
			divide(startRow, startCol + nextSize, nextSize);
			divide(startRow, startCol + nextSize * 2, nextSize);
			divide(startRow + nextSize, startCol, nextSize);
			divide(startRow + nextSize, startCol + nextSize, nextSize);
			divide(startRow + nextSize, startCol + nextSize * 2, nextSize);
			divide(startRow + nextSize * 2, startCol, nextSize);
			divide(startRow + nextSize * 2, startCol + nextSize, nextSize);
			divide(startRow + nextSize * 2, startCol + nextSize * 2, nextSize);
		}
	}

	private static boolean isSame(int startRow, int startCol, int size) {
		int stdNum = arr[startRow][startCol];

		for (int i = startRow; i < startRow + size; i++) {
			for (int j = startCol; j < startCol + size; j++) {
				if (arr[i][j] != stdNum) {
					return false;
				}
			}
		}

		return true;
	}

	private static void count(int num) {
		switch (num) {
			case -1:
				answer[0] += 1;
				break;
			case 0:
				answer[1] += 1;
				break;
			case 1:
				answer[2] += 1;
				break;
		}
	}
}
