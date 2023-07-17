package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2343 {
	static int n;
	static int[] lessons;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		lessons = new int[n];
		int start = 0;
		int end = 0;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			int lesson = Integer.parseInt(st.nextToken());
			lessons[i] = lesson;
			start = Math.max(start, lesson);
			end += lesson;
		}

		int size = binarySearch(start, end, m);
		System.out.println(size);
	}

	private static int binarySearch(int start, int end, int target) {
		while (start < end) {
			int mid = (start + end) / 2;
			int count = getCount(mid);

			// 목표보다 더 잘게 쪼개졌을 경우, mid 시간이 작다는 뜻이다.
			// 따라서 start를 큰 값으로 변경하여 mid를 키우고 count를 줄인다.
			if (count > target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return start;
	}

	private static int getCount(int mid) {
		int count = 0;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			if (sum + lessons[i] > mid) {
				sum = 0;
				count++;
			}

			sum += lessons[i];
		}

		// 마지막 카운트가 안되는 경우
		if (sum != 0) {
			count++;
		}

		return count;
	}
}
