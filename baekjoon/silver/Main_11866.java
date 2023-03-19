package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Deque<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		sb.append("<");

		while (!q.isEmpty()) {
			// k - 1번 반복
			for (int i = 1; i < k; i++) {
				q.add(q.poll());
			}

			// k번은 제거
			sb.append(q.poll()).append(", ");
		}

		// 마지막 쉼표 지우기
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");

		System.out.println(sb);
	}
}
