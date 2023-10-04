package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649 {
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[N + 1];

		appendNum(N, M, 0);

		System.out.print(sb);
	}

	public static void appendNum(int N, int M, int depth) {
		if (depth == M) {
			for (int i : arr)
				sb.append(i).append(' ');
			sb.append('\n');
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			arr[depth] = i;
			appendNum(N, M, depth + 1);
			visited[i] = false;
		}
	}
}
