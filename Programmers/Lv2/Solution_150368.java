package Lv2;

import java.util.Arrays;

public class Solution_150368 {
	static final int[] DISCOUNT_RATES = new int[] {10, 20, 30, 40};
	static int[] answer;

	public int[] solution(int[][] users, int[] emoticons) {
		// 완전 탐색 (재귀 or while로 풀어야 될 거 같은데)

		answer = new int[2];

		getRates(users, emoticons, 0, new int[emoticons.length]);

		return answer;
	}

	public void getRates(int[][] users, int[] emoticons, int depth, int[] rates) {
		if (depth == emoticons.length) {
			int[] arr = getAnswer(users, emoticons, rates);
			setAnswer(arr);
			return;
		}

		for (int rate : DISCOUNT_RATES) {
			rates[depth] = rate;
			getRates(users, emoticons, depth + 1, rates);
		}
	}

	public int[] getAnswer(int[][] users, int[] emoticons, int[] rates) {
		int plus = 0;
		int benefit = 0;

		Loop1:
		for (int[] user : users) {
			int curUserPrice = 0;
			int maxRate = user[0];
			int maxPrice = user[1];

			for (int i = 0; i < emoticons.length; i++) {
				int price = emoticons[i] * (100 - rates[i]) / 100;

				// 원하는 할인율보다 높아야 구매
				if (rates[i] >= maxRate) {
					curUserPrice += price;
				}

				// 구매 가격이 임계점을 넘으면 이모티콘 플러스 구매
				if (curUserPrice >= maxPrice) {
					plus += 1;
					continue Loop1;
				}
			}

			// 아니라면 이모티콘 판매액 추가
			benefit += curUserPrice;
		}

		return new int[] {plus, benefit};
	}

	public void setAnswer(int[] arr) {
		// 이모티콘 플러스 판매량이 우선
		if (answer[0] < arr[0]) {
			answer = arr;
		}
		// 이후 판매액이 우선
		else if (answer[0] == arr[0] && answer[1] < arr[1]) {
			answer = arr;
		}
	}

	public static void main(String[] args) {
		Solution_150368 sol = new Solution_150368();

		int[] sol1 = sol.solution(
			new int[][] {{40, 10000}, {25, 10000}},
			new int[] {7000, 9000});
		int[] sol2 = sol.solution(
			new int[][] {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}},
			new int[] {1300, 1500, 1600, 4900});

		System.out.println(Arrays.toString(sol1));
		System.out.println(Arrays.toString(sol2));
	}
}

/*
class Solution {
	static int[] discounts = new int[] {10, 20, 30, 40};
	static int[] answer;

	public int[] solution(int[][] users, int[] emoticons) {
		// 완전 탐색 (재귀 or While로 풀어야 될 거 같은데)

		answer = new int[2];

		int[] usersPrice = new int[users.length];

		buy(users, emoticons, 0, usersPrice);

		return answer;
	}

	public void buy(int[][] users, int[] emoticons, int depth, int[] usersPrice) {
		if (depth == emoticons.length) {
			int[] curAnswer = calcMaxUser(usersPrice);

			if (answer[0] < curAnswer[0]) {
				answer = curAnswer;
			} else if (answer[0] == curAnswer[0]) {
				if (answer[1] < curAnswer[1]) {
					answer = curAnswer;
				}
			}

			return;
		}

		for (int d = 0; d < discounts.length; d++) {
			int price = emoticons[depth] * discounts[d] / 100;

			for (int i = 0; i < users.length; i++) {
				if (usersPrice[i] == -1) {
					continue;
				}

				int[] user = users[i];

				if (discounts[d] >= user[0]) {
					usersPrice[i] += price;
				}

				if (usersPrice[i] >= user[1]) {
					usersPrice[i] = -1;
				}
			}

			buy(users, emoticons, depth+1, usersPrice);
		}
	}

	public int[] calcMaxUser(int[] usersPrice) {
		int cnt = 0;
		int benefit = 0;

		for (int price : usersPrice) {
			if (price == -1) {
				cnt++;
				continue;
			}

			benefit += price;
		}

		return new int[] {cnt, benefit};
	}
}
 */
