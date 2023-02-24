package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main_2935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String a = br.readLine();
		String op = br.readLine();
		String b = br.readLine();

		switch (op) {
			case "*":
				sb.append(a);
				sb.append(b.substring(1));
				System.out.println(sb);
				break;

			case "+":
				// 동일한 자릿 수의 숫자가 들어올 경우
				if (Objects.equals(a, b)) {
					sb.append("2");
					for (int i = 0; i < a.length() - 1; i++) {
						sb.append("0");
					}
					System.out.println(sb);
					break;
				}

				// 서로 다른 자릿 수의 숫자가 들어올 경우
				int m = Math.max(a.length(), b.length()) - 1;
				int n = Math.min(a.length(), b.length()) - 1;

				sb.append("1");
				for (int i = 1; i <= m; i++) {
					if (m - n == i) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}

				System.out.println(sb);
				break;
		}
	}
}
