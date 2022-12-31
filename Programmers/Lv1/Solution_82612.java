package Lv1;

public class Solution_82612 {
	public long solution(int price, int money, int count) {
		long total = 0;

		for (int i = 1; i <= count; i++) {
			total += ((long) price * i);
		}

		total = total - (long) money;

		return total > 0 ? total : 0;
	}
}
