package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

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
		Deque<String> q = new ArrayDeque<>();

		for (int i = 0; i < ps.length(); i++) {
			char c = ps.charAt(i);

			if (c == '(') {
				q.add("(");
			}

			if (c == ')') {
				if (q.isEmpty()) {
					return false;
				}

				if (!q.peekLast().equals("(")) {
					return false;
				}

				q.poll();
			}
		}

		return q.isEmpty();
	}
}
