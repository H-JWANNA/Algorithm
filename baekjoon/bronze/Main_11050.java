package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11050 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// DP를 사용하기 위한 배열 (k가 0인 경우를 방지하여 0번 index도 1을 넣어준다)
		arr = new int[n + 1];
		arr[0] = 1;
		arr[1] = 1;

		System.out.println(factorial(n) / (factorial(k) * factorial(n - k)));
	}

	private static int factorial(int n) {

		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] * i;
		}

		return arr[n];
	}
}
