package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Deque<String> q = new ArrayDeque<>();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
				case "push":
					q.add(st.nextToken());
					break;
				case "pop":
					sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
					break;
				case "size":
					sb.append(q.size()).append("\n");
					break;
				case "empty":
					sb.append(q.isEmpty() ? 1 : 0).append("\n");
					break;
				case "front":
					sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
					break;
				case "back":
					sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
					break;
			}
		}

		System.out.println(sb);
	}
}
