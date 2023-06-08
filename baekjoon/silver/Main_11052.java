package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052 {
	static int[] cards;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		cards = new int[n + 1];

		for (int i = 1; i < cards.length; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		/*
			카드를 살 수 있는 경우의 수는 다음과 같다.
			ex) 11개를 살 경우 => [11, 10 + 1, 9 + 2, 8 + 3, 7 + 4, 6 + 5]

			따라서 (n - n / 2)번째까지 비교를 하며 최대가 되는 가격을 구한다.
		 */

		// Bottom-up
		for (int i = 2; i < cards.length; i++) {
			cards[i] = getMax(i);
		}

		System.out.println(cards[n]);
	}

	private static int getMax(int index) {
		int mid = index - index / 2;
		int max = 0;

		for (int i = index; i >= mid; i--) {
			max = Math.max(max, cards[i] + cards[index - i]);
		}

		return max;
	}
}
