package Lv3;

public class Solution_43162 {
	static int[] parents;

	public int solution(int n, int[][] computers) {
		parents = new int[n];

		for(int i = 0; i < n; i++) {
			parents[i] = i;
		}

		for(int i = 0; i < n * 2; i++) {
			for(int j = 0; j < n * 2; j++) {
				int ii = i % n;
				int jj = j % n;

				if (computers[ii][jj] == 0) {
					continue;
				}

				int x = find(ii);
				int y = find(jj);

				if (x != y) {
					change(x, y);
				}
			}
		}

		int answer = 0;

		for(int i = 0; i < n; i++) {
			if (parents[i] == -1 || parents[parents[i]] == -1) {
				continue;
			}

			parents[i] = -1;
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
