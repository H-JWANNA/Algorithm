package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();

		int count = 0;
		int stack = 0;
		int len = 2 * n + 1;
		boolean I = false;

		for (int i = 0; i < m; i++) {
			if (s.charAt(i) == 'I') {
				if (!I) {
					stack++;
					I = true;
				} else {
					stack = 1;
				}
			} else {
				if (I) {
					stack++;
					I = false;
				} else {
					stack = 0;
				}
			}

			if (stack == len) {
				count++;
				stack -= 2;
			}
		}

		System.out.println(count);
	}
}
