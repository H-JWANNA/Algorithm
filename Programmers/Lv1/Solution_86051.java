package Lv1;

public class Solution_86051 {
	public int solution(int[] numbers) {
		// 0 ~ 9를 더하면 45
		int answer = 45;

		for (int number : numbers) {
			answer -= number;
		}

		return answer;
	}
}
