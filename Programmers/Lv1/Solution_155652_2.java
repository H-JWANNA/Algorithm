package Lv1;

public class Solution_155652_2 {
	static boolean[] skips;

	public String solution(String s, String skip, int index) {
		skips = new boolean[26];
		initSkips(skip);

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char changedC = change(c, index);

			sb.append(changedC);
		}

		return sb.toString();
	}

	public char change(char c, int index) {
		int cur = c - 'a';
		int idx = index;

		while (index > 0) {
			cur++;

			if (cur > 25) {
				cur = 0;
			}

			if (skips[cur]) {
				continue;
			}

			index--;
		}

		return (char)(cur + 'a');
	}

	public void initSkips(String skip) {
		for(int i = 0; i < skip.length(); i++) {
			int idx = skip.charAt(i) - 'a';
			skips[idx] = true;
		}
	}
}
