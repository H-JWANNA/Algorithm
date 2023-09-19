package Lv3;

public class Solution_214289 {
	static int INF = 987_654;
	static int MAX_TIME;
	static int MAX_TEMP;

	public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
		// 실외 온도는 항상 희망 온도보다 낮은 값으로 세팅 (항상 히터를 틀어야함, turn off 시 온도가 하강함)
		int temp = setTemp(temperature, t1, t2);
		int plus = temp + 10 < 0 ? Math.abs(temp) : 10;

		t1 += plus;
		t2 += plus;
		temp += plus;

		System.out.println(t1 + " " + t2 + " " + temp);

		MAX_TIME = onboard.length;
		MAX_TEMP = 40 + plus;

		int[][] dp = new int[MAX_TIME][MAX_TEMP + 1];

		// ===== DP 배열 초기화 =====
		for (int i = 0; i < MAX_TIME; i++) {
			for (int j = 0; j <= MAX_TEMP; j++) {
				dp[i][j] = INF;
			}
		}

		dp[0][temp] = 0;

		// ===== DP 계산 =====
		for (int i = 1; i < MAX_TIME; i++) {
			int start = onboard[i] == 1 ? t1 : 0;
			int end = onboard[i] == 1 ? t2 : MAX_TEMP;

			for (int j = start; j <= end; j++) {

				// turn on (온도 변경)
				if (0 < j) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + a);
					// System.out.println("온도 변경 : " + i + " " + j + " " + dp[i][j]);
				}

				// turn on (온도 유지)
				if (t1 <= j && j <= t2) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + b);
					// System.out.println("온도 유지 : " + i + " " + j + " " + dp[i][j]);
				}

				// turn off (외부 온도가 더 낮음)
				if (j + 1 <= MAX_TEMP) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1]);
					// System.out.println("온도 떨어짐 : " + i + " " + j + " " + dp[i][j]);
				}

				// turn off (외부 온도와 같음)
				if (j == temp) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
					// System.out.println("온도 같음 : " + i + " " + j + " " + dp[i][j]);
				}
			}
		}

		// ===== 출력 =====
		int answer = INF;

		for (int j = 0; j <= MAX_TEMP; j++) {
			answer = Math.min(answer, dp[MAX_TIME - 1][j]);
		}

		return answer;
	}

	public int setTemp(int temperature, int t1, int t2) {
		if (temperature > t2) {
			return t1 - (temperature - t2);
		}

		return temperature;
	}

	public static void main(String[] args) {
		Solution_214289 sol = new Solution_214289();

		System.out.println(
			sol.solution(28, 18, 26, 10, 8,
				new int[] {0, 0, 1, 1, 1, 1, 1}) == 40);

		System.out.println(
			sol.solution(-3, -10, -5, 5, 1,
				new int[] {0, 0, 0, 0, 1}) == 10);
	}
}
