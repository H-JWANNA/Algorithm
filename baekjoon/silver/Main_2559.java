package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	메모리 : 23772KB
	시간 : 1936ms
 */

public class Main_2559 {
	static int[] temps;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		temps = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			temps[i] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= n - k; i++) {
			int sum = getSum(i, k);

			max = Math.max(max, sum);
		}

		System.out.println(max);
	}

	private static int getSum(int start, int date) {
		int sum = 0;

		while (date-- > 0) {
			sum += temps[start];
			start++;
		}

		return sum;
	}
}
