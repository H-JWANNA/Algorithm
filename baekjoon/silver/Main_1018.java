package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());    // 세로
		int m = Integer.parseInt(st.nextToken());    // 가로

		int result = Integer.MAX_VALUE;
		String[] board = new String[n];

		for (int i = 0; i < n; i++) {
			board[i] = br.readLine();
		}

		// 8x8 체스판을 만들기 위한 index
		for (int i = 0; i < n - 7; i++) {
			int checkedCount = Math.min(
				boardCheck(board, i, 'W', 'B'),
				boardCheck(board, i, 'B', 'W'));

			result = Math.min(result, checkedCount);
		}

		System.out.println(result);
	}

	private static int boardCheck(String[] board, int index, char firstChar, char secondChar) {
		int result = Integer.MAX_VALUE;

		// 8x8 체스판을 만들기 위한 index
		for (int m = 0; m < board[0].length() - 7; m++) {
			int checkedCount = 0;

			for (int i = index; i < index + 8; i++) {
				// 홀수 줄은 해당 라인의 첫 글자가 first, 다음 글자가 second 여야 한다.
				if (i % 2 == 0) {
					checkedCount += lineCheck(board[i], m, firstChar, secondChar);
				}
				// 짝수 줄은 해당 라인의 첫 글자가 second, 다음 글자가 first 여야 한다.
				else {
					checkedCount += lineCheck(board[i], m, secondChar, firstChar);
				}
			}

			result = Math.min(result, checkedCount);
		}

		return result;
	}

	private static int lineCheck(String line, int index, char firstChar, char secondChar) {
		int checkedCount = 0;

		for (int i = index; i < index + 8; i++) {
			if (i % 2 == 0 && line.charAt(i) != firstChar) {
				checkedCount++;
			}
			if (i % 2 == 1 && line.charAt(i) != secondChar) {
				checkedCount++;
			}
		}

		return checkedCount;
	}
}
