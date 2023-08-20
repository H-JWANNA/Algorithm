package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int lcm = m * n / gcd(m, n);
			int answer = -1;

			for (int i = 0; i * m < lcm; i++) {
				if ((i * m + x - y) % n == 0) {
					answer = i * m + x;
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

	static int gcd(int m, int n) {
		if (n == 0) {
			return m;
		}

		return gcd(n, m % n);
	}
}
