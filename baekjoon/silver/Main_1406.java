package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Character> stack = new Stack<>();
		Stack<Character> temps = new Stack<>();
		String s = br.readLine();

		for (int i = 0; i < s.length(); i++) {
			stack.add(s.charAt(i));
		}

		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
				case "L":
					if (!stack.empty()) {
						temps.add(stack.pop());
					}
					break;
				case "D":
					if (!temps.empty()) {
						stack.add(temps.pop());
					}
					break;
				case "B":
					if (!stack.empty()) {
						stack.pop();
					}
					break;
				case "P":
					stack.add(st.nextToken().charAt(0));
					break;
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!temps.empty()) {
			stack.add(temps.pop());
		}

		for (Character c : stack) {
			sb.append(c);
		}

		System.out.println(sb);
	}
}
