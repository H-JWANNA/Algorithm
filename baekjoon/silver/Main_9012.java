package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String ps = br.readLine();

			System.out.println(isVps(ps) ? "YES" : "NO");
		}
	}

	private static boolean isVps(String ps) {
		Stack<String> s = new Stack<>();

		for (int i = 0; i < ps.length(); i++) {
			char c = ps.charAt(i);

			switch (c) {
				case '(':
					s.add("(");
					break;

				case ')':
					if (s.isEmpty()) {
						return false;
					}

					if (!s.pop().equals("(")) {
						return false;
					}
			}
		}

		return s.isEmpty();
	}
}
