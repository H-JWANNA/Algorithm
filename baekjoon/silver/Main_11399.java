package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력
		int[] times = new int[n];

		for (int i = 0; i < times.length; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(times);

		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += times[i] * (n - i);
		}

		System.out.println(sum);
	}
}
