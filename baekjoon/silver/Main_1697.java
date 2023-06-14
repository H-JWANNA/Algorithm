package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int answer;

		// 만약 동생이 더 뒤에 있다면 -1로만 갈 수 있다.
		if (n >= k) {
			answer = n - k;
		} else {
			answer = bfs(n, k);
		}

		System.out.println(answer);
	}

	private static int bfs(int n, int k) {
		// 현재 위치와 몇 번 움직였는지를 담는 배열
		int[] arr = new int[] {n, 0};

		Queue<int[]> q = new ArrayDeque<>();
		q.add(arr);

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int node = cur[0];
			int count = cur[1];

			visited[node] = true;

			if (cur[0] == k) {
				return count;
			}

			if (node > 0 && !visited[node - 1]) {
				q.add(new int[]{node - 1, count + 1});
			}
			if (node < 100000 && !visited[node + 1]) {
				q.add(new int[]{node + 1, count + 1});
			}
			if (node != 0 && node <= 50000 && !visited[node * 2]) {
				q.add(new int[]{node * 2, count + 1});
			}
		}

		return -1;
	}
}
