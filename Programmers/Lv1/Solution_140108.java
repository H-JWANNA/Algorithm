package Lv1;

public class Solution_140108 {
	public int solution(String s) {
		int answer = 1;

		char start = s.charAt(0);

		int same = 1;
		int diff = 0;

		for(int i = 1; i < s.length(); i++) {
			if (same == diff) {
				start = s.charAt(i);
				same++;
				answer++;
			} else {
				char c = s.charAt(i);
				if (start == c) {
					same++;
				} else {
					diff++;
				}
			}
		}

		return answer;
	}
}
