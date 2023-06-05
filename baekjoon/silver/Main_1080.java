package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1080 {
	static final int SIZE = 3;
	static int count;
	static boolean[][] before;
	static boolean[][] after;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// === 입력 ===
		count = 0;
		before = new boolean[n][m];
		after = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				before[i][j] = (line.charAt(j) == '1');
			}
		}

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				after[i][j] = (line.charAt(j) == '1');
			}
		}

		// 만약 해당 [y][x] 좌표의 값이 before, after 가 다르다면 바꿔보기
		for (int y = 0; y <= n - SIZE; y++) {
			for (int x = 0; x <= m - SIZE; x++) {
				if (before[y][x] != after[y][x]) {
					reverse(y, x);
				}
			}
		}

		// 배열이 서로 같다면 count, 다르다면 -1 출력
		if (Arrays.deepEquals(before, after)) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
	}

	private static void reverse(int y, int x) {
		for (int i = y; i < y + SIZE; i++) {
			for (int j = x; j < x + SIZE; j++) {
				before[i][j] = !before[i][j];
			}
		}

		count++;
	}
}
