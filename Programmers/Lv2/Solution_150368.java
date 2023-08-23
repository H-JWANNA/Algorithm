package Lv2;

import java.util.Arrays;
/*
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
*/

public class Solution_150368 {
	static final int[] DISCOUNT_RATES = new int[] {10, 20, 30, 40};
	static int[] answer;

	public int[] solution(int[][] users, int[] emoticons) {
		answer = new int[2];

		buy(users, emoticons, 0, new int[users.length]);

		return answer;
	}

	public void buy(int[][] users, int[] emoticons, int depth, int[] usersPrice) {
		if (depth == emoticons.length) {
			int[] curAnswer = getAnswer(users, usersPrice);
			setAnswer(curAnswer);
			return;
		}

		for (int rate : DISCOUNT_RATES) {
			int price = emoticons[depth] * (100 - rate) / 100;
			int[] curUsersPrice = Arrays.copyOf(usersPrice, usersPrice.length);

			for (int i = 0; i < users.length; i++) {
				int[] user = users[i];

				if (rate >= user[0]) {
					curUsersPrice[i] += price;
				}
			}

			System.out.println("depth: " + depth);
			System.out.println("rate = " + rate);
			System.out.println(Arrays.toString(curUsersPrice));
			buy(users, emoticons, depth + 1, curUsersPrice);
		}
	}

	public int[] getAnswer(int[][] users, int[] usersPrice) {
		int plus = 0;
		int benefit = 0;

		for (int i = 0; i < usersPrice.length; i++) {
			if (usersPrice[i] >= users[i][1]) {
				plus++;
			} else {
				benefit += usersPrice[i];
			}
		}

		return new int[] {plus, benefit};
	}

	public void setAnswer(int[] arr) {
		if (answer[0] < arr[0]) {
			answer = arr;
		} else if (answer[0] == arr[0] && answer[1] < arr[1]) {
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
