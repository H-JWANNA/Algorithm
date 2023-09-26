package Lv2;

public class Solution_42860 {
	public int solution(String name) {
		int answer = 0;
		int len = name.length();
		int move = len - 1;

		for(int i = 0; i < len; i++) {
			// 상하 최소값 찾기
			char c = name.charAt(i);
			answer += upDown(c);

			// 좌우 최소값 찾기
			int index = i + 1;
			while(index < len && name.charAt(index) == 'A') {
				index++;
			}

			// 1. 우측으로 먼저 간 뒤 좌측으로 이동
			move = Math.min(move, (i * 2) + (len - index));

			// 2. 좌측으로 먼저 간 뒤 우측으로 이동
			move = Math.min(move, (len - index) * 2 + i);
		}

		return answer + move;
	}

	public int upDown(char c) {
		int num = c - 'A';

		return num > 12 ? 26 - num : num;
	}

	public static void main(String[] args) {
		Solution_42860 sol = new Solution_42860();

		System.out.println(sol.solution("JEROEN") == 56);
		System.out.println(sol.solution("JAN") == 23);
		System.out.println(sol.solution("AAAAAAA") == 0);
		System.out.println(sol.solution("BABAB") == 6);
		System.out.println(sol.solution("BBAAAAAAAB") == 6);
		System.out.println(sol.solution("BBBBBAAAB") == 12);
	}
}
