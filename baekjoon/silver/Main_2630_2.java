package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_2 {
	static boolean[][] board;
	static int[] counts = new int[2];	// 0 : white, 1 : blue

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력
		int n = Integer.parseInt(br.readLine());
		board = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					board[i][j] = true;
				}
			}
		}

		divide(0, 0, n);

		System.out.print(counts[0] + "\n" + counts[1]);
	}

	// 분할 정복을 하기 위한 메서드
	private static void divide(int i, int j, int len) {
		// 탈출 조건
		if (isAllSame(i, j, len)) {
			counts[color(board[i][j])] += 1;
			return;
		}

		// 4방향 탐색
		divide(i, j, len / 2);
		divide(i, j + len / 2, len / 2);
		divide(i + len / 2, j, len / 2);
		divide(i + len / 2, j + len / 2, len / 2);
	}

	// 해당 구역이 모두 같은 색인지 확인
	private static boolean isAllSame(int i, int j, int len) {
		boolean first = board[i][j];

		for (int y = i; y < i + len; y++) {
			for (int x = j; x < j + len; x++) {
				if (first != board[y][x]) {
					return false;
				}
			}
		}

		return true;
	}

	// 파란색이면 1, 흰색이면 0
	private static int color(boolean first) {
		return first ? 1 : 0;
	}
}
