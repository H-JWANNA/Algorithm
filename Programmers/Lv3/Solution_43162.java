package Lv3;

public class Solution_43162 {
	static int[] parents;
	static boolean[] isCounted;

	public int solution(int n, int[][] computers) {
		parents = new int[n];
		isCounted = new boolean[n];

		for(int i = 0; i < n; i++) {
			parents[i] = i;
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if (computers[i][j] == 0) {
					continue;
				}

				int x = find(i);
				int y = find(j);

				if (x != y) {
					change(x, y);
				}
			}
		}

		int answer = 0;

		for(int i = 0; i < n; i++) {
			if (isCounted[find(parents[i])]) {
				continue;
			}

			isCounted[i] = true;
			answer++;
		}

		return answer;
	}

	public int find(int n) {
		if (n == parents[n]) {
			return n;
		}

		return parents[n] = find(parents[n]);
	}

	public void change(int x, int y) {
		if (x > y) {
			parents[x] = y;
		} else {
			parents[y] = x;
		}
	}
}
