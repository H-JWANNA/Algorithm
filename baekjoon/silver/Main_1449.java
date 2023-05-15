package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());    // 물이 새는 곳의 수
		int tape = Integer.parseInt(st.nextToken());    // 테이프 길이

		int[] pipe = new int[n];    // 물이 새는 곳
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			pipe[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(pipe);

		/*
		 	1. 물을 막기 시작할 곳을 변수로 둔다.
		 	2. 시작 지점부터 목표 지점 +1 까지가 테이프 길이 이내여야 한다.
		 	3. 마지막 테이프를 셀 수 없으므로 count + 1 값을 반환한다.
		 */

		int start = pipe[0];
		int count = 0;

		for (int i = 1; i < pipe.length; i++) {
			int current = pipe[i];

			if (current - start + 1 > tape) {
				count += 1;
				start = current;
			}
		}

		System.out.println(count + 1);
	}
}
