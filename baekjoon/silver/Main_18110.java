package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_18110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] opinions = new int[n];

		for (int i = 0; i < n; i++) {
			opinions[i] = Integer.parseInt(br.readLine());
		}

		// 정렬
		Arrays.sort(opinions);

		// 절사 평균
		int cut = (int) Math.round(n * 0.15);

		// 총합
		double sum = 0;
		for (int i = cut; i < n - cut; i++) {
			sum += opinions[i];
		}

		// 평균
		int avg = (int) Math.round(sum / (n - cut * 2));

		System.out.println(avg);
	}
}
