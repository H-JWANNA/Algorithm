package Lv1;

public class Solution_132267 {
	public static void main(String[] args) {
		int a1 = 2, a2 = 3;
		int b = 1;
		int n = 20;

		System.out.println(solution(a1, b, n));
		System.out.println(solution(a2, b, n));
		System.out.println(solution(3, 2, 20));
	}

	public static int solution(int a, int b, int n) {
		int answer = 0;
		int blank = n;

		while (blank >= a) {
			int get = (blank / a) * b;

			blank = blank % a;
			answer += get;
			blank += get;

			System.out.println("빈병 : " + blank);
		}

		return answer;
	}
}
