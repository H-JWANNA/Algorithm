package Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_150370 {
	static final int M = 12;
	static final int D = 28;

	static StringTokenizer st;
	static int[] expirationDate = new int[26];

	public int[] solution(String today, String[] terms, String[] privacies) {
		setExpirationDate(terms);

		int[] answer = validatePrivacies(today, privacies).stream()
			.mapToInt(o -> o)
			.toArray();

		return answer;
	}

	public ArrayList<Integer> validatePrivacies(String today, String[] privacies) {
		ArrayList<Integer> breaks = new ArrayList<>();
		int iToday = dateToInt(today);

		for (int i = 0; i < privacies.length; i++) {
			st = new StringTokenizer(privacies[i], " ");
			String date = st.nextToken();
			char term = st.nextToken().charAt(0);
			int iDate = dateToInt(date);

			// 2022.05.19 : 679551
			// 2022.05.02 : 679534
			// 오늘이 더 크거나 같다면 만료 날짜가 오늘보다 작다는 뜻이므로 만료된 것이다.
			if (iToday >= iDate + expirationDate[term - 'A']) {
				breaks.add(i + 1);
			}
		}

		return breaks;
	}

	public void setExpirationDate(String[] terms) {
		for (String term : terms) {
			st = new StringTokenizer(term, " ");
			char c = st.nextToken().charAt(0);
			int month = Integer.parseInt(st.nextToken());

			expirationDate[c - 'A'] = month * D;
		}
	}

	public int dateToInt(String date) {
		st = new StringTokenizer(date, ".");
		int year = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());

		return day + (month * D) + ((year - 1999) * M * D);
	}

	public static void main(String[] args) {
		Solution_150370 sol = new Solution_150370();

		int[] sol1 = sol.solution("2022.05.19", new String[] {"A 6", "B 12", "C 3"},
			new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});

		int[] sol2 = sol.solution("2020.01.01", new String[] {"Z 3", "D 5"},
			new String[] {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"});

		System.out.println(Arrays.toString(sol1));
		System.out.println(Arrays.toString(sol2));
	}
}
