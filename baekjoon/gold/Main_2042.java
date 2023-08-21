package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2042 {
	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		// 2^x >= n 인 최소의 x를 찾아야한다.
		int x = (int)Math.ceil(Math.log(n) / Math.log(2)) + 1;
		int size = (int)Math.pow(2, x);

		tree = new long[size];
		construct(1, n, 1);

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			switch (a) {
				case 1:
					long val = c - arr[b];
					arr[b] = c;
					update(1, n, 1, b, val);
					break;
				case 2:
					long sum = sum(1, n, 1, b, (int)c);
					sb.append(sum).append("\n");
					break;
			}
		}

		System.out.print(sb);
	}

	static long construct(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;

		return tree[node] = construct(start, mid, node * 2) + construct(mid + 1, end, node * 2 + 1);
	}

	/*
		start, end : 시작, 끝 인덱스
		node : 현재 노드의 인덱스
		left, right : 구하려고 하는 구간 합의 범위
	 */
	static long sum(int start, int end, int node, int left, int right) {
		// 해당 범위에 아예 포함되지 않는 경우 0 리턴
		if (right < start || left > end) {
			return 0;
		}

		// 완전히 범위에 포함되는 경우 해당 노드의 값 리턴
		if (left <= start && right >= end) {
			return tree[node];
		}

		int mid = (start + end) / 2;

		// 양쪽으로 나눠서 이분탐색
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}

	static void update(int start, int end, int node, int idx, long val) {
		// 범위 밖이라면 업데이트 하지 않는다
		if (idx < start || idx > end) {
			return;
		}

		// 범위 내에 있다면 업데이트 한다
		tree[node] += val;
		if (start == end) {
			return;
		}

		int mid = (start + end) / 2;
		update(start, mid, node * 2, idx, val);
		update(mid + 1, end, node * 2 + 1, idx, val);
	}
}
