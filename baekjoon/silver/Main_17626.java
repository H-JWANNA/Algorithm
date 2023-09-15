package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17626 {
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		dp = new int[n + 1];

		// ===== 초기화 =====
		Arrays.fill(dp, 5);

		for (int i = 1; i <= (int)Math.sqrt(n); i++) {
			dp[(int)Math.pow(i, 2)] = 1;
		}

		// ===== 계산 =====
		for (int i = 2; i <= n; i++) {
			int sqrt = (int)Math.sqrt(i);

			for (int sq = sqrt; sq > 0; sq--) {
				int num = (int)Math.pow(sq, 2);
				int mod = i - num;

				dp[i] = Math.min(dp[i], dp[mod] + 1);
			}
		}

		System.out.println(dp[n]);
	}
}
