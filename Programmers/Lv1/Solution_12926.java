package Lv1;

public class Solution_12926 {
	public static void main(String[] args) {
		System.out.println(solution("AB", 1));
		System.out.println(solution("z", 1));
		System.out.println(solution("a B z", 4));
	}

	public static String solution(String s, int n) {
		char[] arr = s.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (char c : arr) {
			if (c == ' ') {
				sb.append(" ");
			}

			if (c >= 65 && c <= 90) {
				c += n;
				if (c > 90) {
					c -= 26;
				}

				sb.append(c);
			}

			if (c >= 97 && c <= 122) {
				c += n;
				if (c > 122) {
					c -= 26;
				}

				sb.append(c);
			}
		}

		return sb.toString();
	}
}
