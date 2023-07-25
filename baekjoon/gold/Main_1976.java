package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976 {
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		/*
			부모 배열을 생성한다. (초기값은 본인 인덱스를 가진다.)
			도시의 여행 경로를 입력 받으면서 합집합을 형성한다. (최소 값을 부모로 설정)
			여행 계획을 순회하면서 모두 부모가 같은지 확인한다.
		 */

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		parents = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= n; j++) {
				if (st.nextToken().equals("1")) {
					int x = search(i);
					int y = search(j);

					if (x != y) {
						change(x, y);
					}
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int city = Integer.parseInt(st.nextToken());

		while (--m > 0) {
			int cur = Integer.parseInt(st.nextToken());

			if (parents[city] != parents[cur]) {
				break;
			}
		}

		System.out.println(m == 0 ? "YES" : "NO");
	}

	private static void change(int x, int y) {
		if (x < y) {
			parents[y] = x;
		} else {
			parents[x] = y;
		}
	}

	private static int search(int node) {
		if (node == parents[node]) {
			return node;
		}

		parents[node] = search(parents[node]);

		return parents[node];
	}
}
