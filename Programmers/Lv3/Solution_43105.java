package Lv3;

public class Solution_43105 {
	static int DEPTH;
	static int MAX_LEN;

	public int solution(int[][] triangle) {
		DEPTH = triangle.length;
		MAX_LEN = triangle[DEPTH - 1].length;

		for(int i = 1; i < DEPTH; i++) {
			for(int j = 0; j < triangle[i].length; j++) {
				if (j == 0) {
					triangle[i][j] += triangle[i - 1][j];
				} else if (j == triangle[i].length - 1) {
					triangle[i][j] += triangle[i - 1][j - 1];
				} else {
					int before = Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
					triangle[i][j] += before;
				}
			}
		}

		int answer = 0;

		for(int j = 0; j < MAX_LEN; j++) {
			answer = Math.max(answer, triangle[DEPTH - 1][j]);
		}

		return answer;
	}
}
