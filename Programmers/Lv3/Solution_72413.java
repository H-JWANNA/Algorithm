package Lv3;

/*
	정확성: 45.0
	효율성: 40.0
	합계: 85.0 / 100.0금

	=> 실패
 */

public class Solution_72413 {
	static int MAX_FARE = 100_001;

	/**
	 *
	 * @param n : 지점의 개수
	 * @param s : 시작점
	 * @param a : A 집
	 * @param b : B 집
	 * @param fares : [from, to, fare]
	 * @return : A와 B가 합승해서 집에가는 최소 비용
	 */
	public int solution(int n, int s, int a, int b, int[][] fares) {
		int[][] minFares = fw(n, fares);

		int minFare = Integer.MAX_VALUE;

		// 시작점에서 A, B로 가는 경유지별 최소 금액을 계산한다.
		for (int t = 1; t <= n; t++) {
			int st = minFares[s][t];
			int ta = minFares[t][a];
			int tb = minFares[t][b];

			minFare = Math.min(minFare, st + ta + tb);
		}

		return minFare;
	}

	public int[][] fw(int n, int[][] fares) {
		int[][] adjList = makeAdjList(n, fares);

		for (int t = 1; t <= n; t++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j) {
						continue;
					}

					int ij = adjList[i][j];
					int it = adjList[i][t];
					int tj = adjList[t][j];

					adjList[i][j] = Math.min(ij, it + tj);
				}
			}
		}

		return adjList;
	}

	public int[][] makeAdjList(int n, int[][] fares) {
		int[][] adjList = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					continue;
				}

				adjList[i][j] = MAX_FARE;
			}
		}

		for (int[] fare : fares) {
			int a = fare[0];
			int b = fare[1];
			int f = fare[2];

			adjList[a][b] = f;
			adjList[b][a] = f;
		}

		return adjList;
	}

	public static void main(String[] args) {
		Solution_72413 s = new Solution_72413();
		int sol1 = s.solution(6, 4, 6, 2, new int[][] {
			{4, 1, 10},
			{3, 5, 24},
			{5, 6, 2},
			{3, 1, 41},
			{5, 1, 24},
			{4, 6, 50},
			{2, 4, 66},
			{2, 3, 22},
			{1, 6, 25}});

		int sol2 = s.solution(7, 3, 4, 1, new int[][] {
			{5, 7, 9},
			{4, 6, 4},
			{3, 6, 1},
			{3, 2, 3},
			{2, 1, 6}});

		int sol3 = s.solution(6, 4, 5, 6, new int[][] {
			{2, 6, 6},
			{6, 3, 7},
			{4, 6, 7},
			{6, 5, 11},
			{2, 5, 12},
			{5, 3, 20},
			{2, 4, 8},
			{4, 3, 9}});

		System.out.println(sol1);
		System.out.println(sol2);
		System.out.println(sol3);
	}
}
