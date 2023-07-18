package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	메모리 : 23688KB
	시간 : 292ms
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

		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += temps[i];
		}

		int max = sum;

		for (int i = 0; i < n - k; i++) {
			sum -= temps[i];
			sum += temps[i + k];

			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
}
