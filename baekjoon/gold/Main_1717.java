package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1717 {
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		/*
			초기 parents 배열은 자기 자신이 최상을 최상위 노드로 설정한다.
			0을 입력받을 경우 a, b 노드의 값 중 최소 값을 각각 부모로 설정한다.
			1을 입력받을 경우 a, b 노드의 부모가 같은지 확인하고 YES 혹은 NO를 출력한다.
		 */

		parents = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 서로의 부모를 확인한다.
			int x = search(a);
			int y = search(b);

			// 합집합 : 부모가 다르면 작은 값으로 부모를 통일시킨다.
			if (op == 0) {
				if (x != y) {
					if (x < y) {
						parents[y] = x;
					} else {
						parents[x] = y;
					}
				}
			}
			// 확인 : 부모가 같은지 확인한다.
			else {
				sb.append(x == y ? "YES" : "NO").append("\n");
			}
		}

		System.out.print(sb);
	}

	private static int search(int node) {
		if (node == parents[node]) {
			return node;
		}

		return parents[node] = search(parents[node]);
	}
}
