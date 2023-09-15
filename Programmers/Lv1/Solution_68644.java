package Lv1;

import java.util.*;

public class Solution_68644 {
	public int[] solution(int[] numbers) {
		Set<Integer> set = new HashSet<>();

		for(int i = 1; i < numbers.length; i++) {
			for (int j = 0; j < i; j++) {
				int sum = numbers[i] + numbers[j];
				set.add(sum);
			}
		}

		int[] answer = set.stream()
			.mapToInt(o -> o)
			.sorted()
			.toArray();

		return answer;
	}
}
