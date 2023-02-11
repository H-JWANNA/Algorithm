package Lv1;

public class Solution_68935 {
	public static void main(String[] args) {
		int n1 = 45;
		int n2 = 125;

		System.out.println(solution(n1));
		System.out.println(solution(n2));
	}

	public static int solution(int n) {
		// 10진법 -> 3진법
		String s = Integer.toString(n, 3);
		StringBuilder sb = new StringBuilder();

		// 앞뒤 반전 (3진법))
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}

		// 3진법 -> 10진법
		return Integer.parseInt(sb.toString(), 3);
	}
}
