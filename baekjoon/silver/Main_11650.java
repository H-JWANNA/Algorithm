package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		int[][] dots = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			dots[i][0] = Integer.parseInt(st.nextToken());
			dots[i][1] = Integer.parseInt(st.nextToken());
		}

		// 정렬 구현
		Arrays.sort(dots, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// X 좌표가 다른 경우 X 좌표 오름차순 정렬, 같은 경우 Y 좌표 오름차순 정렬
				return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
			}
		});

		// 시간 : 592ms
		for (int i = 0; i < n; i++) {
			sb.append(dots[i][0]).append(" ").append(dots[i][1]).append("\n");
		}

		System.out.println(sb);

		/*
		 * 시간 : 1588ms

		for (int i = 0; i < n; i++) {
			System.out.println(dots[i][0] + " " + dots[i][1]);
		}

		 */
	}
}
