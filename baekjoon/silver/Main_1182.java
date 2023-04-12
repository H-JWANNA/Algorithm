package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182 {
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// dfs(0, n, s, arr, 0);
		powerSet(0, n, s, arr, visited);

		// s가 0일 경우 공집합일 때, 0이므로 1을 빼줌
		System.out.println(s == 0 ? count - 1 : count);
	}

	/* 깊이 우선 탐색
	 * 시간 : 132ms
	 * 메모리 : 14176KB
	 */
	private static void dfs(int depth, int n, int s, int[] arr, int sum) {
		// 끝까지 탐색한 경우
		if (depth == n) {
			// 만약 숫자의 합이 S와 같다면 count 증가
			if (sum == s) {
				count += 1;
			}
			return;
		}

		dfs(depth + 1, n, s, arr, sum + arr[depth]);
		dfs(depth + 1, n, s, arr, sum);
	}

	/* 멱집합
	 * 시간 : 216ms
	 * 메모리 : 15664KB
	 */
	private static void powerSet(int node, int n, int s, int[] arr, boolean[] visited) {
		// 끝까지 탐색한 경우
		if (node == n) {
			int sum = 0;

			// 방문 도장이 찍혔다면, 해당 숫자를 모두 더한다.
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					sum += arr[i];
				}
			}

			// 만약 숫자의 합이 S와 같다면 count를 더한다.
			if (sum == s) {
				count += 1;
			}

			return;
		}

		visited[node] = false;
		powerSet(node + 1, n, s, arr, visited);
		visited[node] = true;
		powerSet(node + 1, n, s, arr, visited);
	}
}
