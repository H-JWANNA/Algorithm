package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack<>();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
				case "push":
					stack.add(st.nextToken());
					break;
				case "pop":
					sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
					break;
				case "size":
					sb.append(stack.size()).append("\n");
					break;
				case "empty":
					sb.append(stack.isEmpty() ? 1 : 0).append("\n");
					break;
				case "top":
					sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
					break;
			}
		}

		System.out.println(sb);
	}
}
