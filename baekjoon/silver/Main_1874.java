package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		int node = 0;

		for (int i = 0; i < n; i++) {
			int cur = Integer.parseInt(br.readLine());

			while (true) {
				if (stack.empty()) {
					node++;
					stack.add(node);
					sb.append("+").append("\n");
				}

				// 목표 숫자까지 가기
				if (cur > stack.peek()) {
					node++;
					stack.add(node);
					sb.append("+").append("\n");
				}
				// 목표 숫자를 찾았을 때
				else if (cur == stack.peek()) {
					stack.pop();
					sb.append("-").append("\n");
					break;
				}
				// 목표 숫자로 갈 수 없을 때
				else if (cur < stack.peek()) {
					System.out.println("NO");
					System.exit(0);
				}
			}
		}

		System.out.print(sb);
	}
}
