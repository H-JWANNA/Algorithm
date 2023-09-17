package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_20529 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String[] students = br.readLine().split(" ");

			if (N > 32) {
				sb.append(0).append("\n");
				continue;
			}

			int min = Integer.MAX_VALUE;

			for (int i = 2; i < N; i++) {
				for (int j = 1; j < i; j++) {
					for (int k = 0; k < j; k++) {
						int answer = 0;

						String s1 = students[i];
						String s2 = students[j];
						String s3 = students[k];

						for (int len = 0; len < 4; len++) {
							char c1 = s1.charAt(len);
							char c2 = s2.charAt(len);
							char c3 = s3.charAt(len);

							if (c1 != c2) {
								answer++;
							}

							if (c1 != c3) {
								answer++;
							}

							if (c2 != c3) {
								answer++;
							}
						}

						min = Math.min(min, answer);
					}
				}
			}

			sb.append(min).append("\n");
		}

		System.out.print(sb);
	}
}
