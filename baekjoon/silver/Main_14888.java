package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14888 {
	static int n;
	static int[] arr;
	static int[] op;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		op = new int[4];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		/*
			1. 각 연산 단계에서 연산자를 몇 번 사용했는지 알아야 한다 (모두 사용했으면 넘어가야함)
			2. 각 연산 단계는 수열의 순서에 대해 노드를 두고 + - * / 를 탐색함
		 */

		search(arr[0]);

		System.out.println(max);
		System.out.println(min);
	}

	private static void search(int value) {
		// int[] : {덧셈, 뺄셈, 곱셈, 나눗셈, 이전 까지의 합, 현재 노드}
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0, 0, 0, 0, value, 1});

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curValue = cur[4];
			int curNode = cur[5];

			// 연산 단계가 모두 끝났다면 max, min 설정
			if (curNode == n) {
				max = Math.max(max, curValue);
				min = Math.min(min, curValue);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				// 연산 갯수를 다 사용했는지 확인
				if (cur[i] == op[i]) {
					continue;
				}

				int[] curOps = {cur[0], cur[1], cur[2], cur[3]};
				curOps[i]++;

				q.add(new int[] {curOps[0], curOps[1], curOps[2], curOps[3],
					calculate(curValue, curNode, i), curNode + 1});
			}
		}
	}

	private static int calculate(int value, int node, int op) {
		switch (op) {
			case 0:
				return value + arr[node];
			case 1:
				return value - arr[node];
			case 2:
				return value * arr[node];
			case 3:
				return value / arr[node];
			default:
				return -1;
		}
	}
}
