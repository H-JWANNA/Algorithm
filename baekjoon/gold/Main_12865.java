package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {
	static int[][] wv;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		wv = new int[n + 1][2];
		dp = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			wv[i][0] = Integer.parseInt(st.nextToken());
			wv[i][1] = Integer.parseInt(st.nextToken());
		}

		/*
			첫번째 값부터 순차적으로 넣으면서 비교를 시작한다.
			현재 W 값에 대한 V와 이전에 입력된 W 값에 대한 V 중 큰 값을 DP 배열에 저장한다.
			만약 무게가 남을 경우 (현재 DP 배열의 무게 - 현재 W 값 >= 0)
			현재 V 값을 더한 총 V와 이전까지 계산한 총 V의 최대 값을 구한다.
			만약 넣을 수 없는 무게가 들어오면 이전 V값을 가져온다.
		 */

		for (int i = 1; i <= n; i++) {
			int cur_w = wv[i][0];
			int cur_v = wv[i][1];

			for (int w = 1; w <= k; w++) {
				if (cur_w > w) {
					dp[i][w] = dp[i - 1][w];
				} else {
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - cur_w] + cur_v);
				}
			}
		}

		System.out.println(dp[n][k]);
	}
}
