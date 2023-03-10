package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int answer = 0;

		// 1번 라인 입력
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 2번 라인 입력
		st = new StringTokenizer(br.readLine());
		int[] cards = new int[n];

		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		// 숫자 3개를 합해서, m이 넘지 않는 최대값 저장
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					// 숫자 3개의 합
					int sum = cards[i] + cards[j] + cards[k];

					// m을 넘으면 그대로, 아니면 최대값
					answer = sum > m ? answer : Math.max(answer, sum);
				}
			}
		}

		System.out.println(answer);
	}
}
