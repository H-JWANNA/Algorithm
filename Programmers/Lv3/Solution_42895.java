package Lv3;

import java.util.HashSet;
import java.util.Set;

public class Solution_42895 {
	static Set<Integer>[] arr = new HashSet[9];

	public int solution(int N, int number) {
		int answer = -1;
		init(N);

		// arr[i]는 arr[i - j]에 arr[j] 사칙연산
		// ex) arr[4] = arr[3] + arr[1], arr[2] + arr[2], arr[1] + arr[3]
		for(int i = 2; i < arr.length; i++) {
			for(int j = 1; j < i; j++) {
				// 내부에 계산된 조합끼리 사칙연산
				for(int num1 : arr[i - j]) {
					for(int num2 : arr[j]) {
						arr[i].add(num1 + num2);
						arr[i].add(num1 - num2);
						arr[i].add(num1 * num2);
						if (num2 != 0) {
							arr[i].add(num1 / num2);
						}
					}
				}
			}
		}

		for(int i = 1; i < arr.length; i++) {
			if (arr[i].contains(number)) {
				return i;
			}
		}

		return answer;
	}

	public void init(int N) {
		String s = "1";

		for(int i = 0; i < arr.length; i++) {
			arr[i] = new HashSet<>();
		}

		for(int i = 1; i < arr.length; i++) {
			String multi = s.repeat(i);

			arr[i].add(N * Integer.parseInt(multi));
		}
	}

	public static void main(String[] args) {
		Solution_42895 sol = new Solution_42895();
		System.out.println(sol.solution(5, 12));
		System.out.println(sol.solution(2, 11));
	}
}
