package Lv2;

import java.util.*;

public class Solution_42746 {
	public String solution(int[] numbers) {
		StringBuilder sb = new StringBuilder();

		String[] arr = Arrays.stream(numbers)
			.mapToObj(Integer::toString)
			.sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
			.toArray(String[]::new);

		// [0, 0, 0] => 0
		if (arr[0].equals("0")) {
			return "0";
		}

		for(String s : arr) {
			sb.append(s);
		}

		return sb.toString();
	}
}
