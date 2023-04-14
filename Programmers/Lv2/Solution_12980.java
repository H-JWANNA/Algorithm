package Lv2;

public class Solution_12980 {
	public static void main(String[] args) {

	}

	public int solution(int n) {
		int battery = 0;

		// n이 0이 될 때까지
		while(n > 0) {
			// 점프는 건전지 사용 O
			if (n % 2 == 1) {
				battery += 1;
				n--;
			}

			// 순간이동은 건전지 사용 X
			n /= 2;
		}

		return battery;
	}
}
