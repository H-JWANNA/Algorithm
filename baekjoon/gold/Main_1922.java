package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1922 {
	static int[] parents;
	static ArrayList<Line> lines;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		parents = new int[n + 1];
		lines = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			lines.add(new Line(a, b, c));
		}

		// cost가 낮은 순으로 정렬한다.
		Collections.sort(lines);

		int count = 0;
		int totalCost = 0;

		// 연결된 갯수가 (정점 갯수 - 1)이 될 때까지 반복한다.
		while (count < n - 1) {
			for (Line line : lines) {
				// 서로 연결되어 있는지 확인하기 위해 유니온 파인드를 사용한다.
				int x = search(line.a);
				int y = search(line.b);

				// 이미 연결되어 있다면 건너뛴다.
				if (x == y) {
					continue;
				}

				// 연결되어 있지 않다면 연결하고 비용을 계산한다.
				change(x, y);
				totalCost += line.cost;
				count++;
			}
		}

		System.out.println(totalCost);
	}

	static void change(int x, int y) {
		if (x < y) {
			parents[y] = x;
		} else {
			parents[x] = y;
		}
	}

	static int search(int node) {
		if (node == parents[node]) {
			return node;
		}

		parents[node] = search(parents[node]);

		return parents[node];
	}

	static class Line implements Comparable<Line> {
		int a;
		int b;
		int cost;

		public Line(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Line o) {
			return this.cost - o.cost;
		}
	}
}
