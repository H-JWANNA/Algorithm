package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(input.readLine());
		int[][] meeting = new int[n][2];
		int result = 0;

		// 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(input.readLine(), " ");

			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}

		// 종료 시간을 기준으로 정렬
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
			}
		});

		// System.out.println(Arrays.deepToString(meeting));

		int endTime = 0;

		for (int i = 0; i < meeting.length; i++) {
			int startTime = meeting[i][0];

			if (startTime >= endTime) {
				endTime = meeting[i][1];
				result += 1;
			}
		}

		System.out.println(result);
	}
}
