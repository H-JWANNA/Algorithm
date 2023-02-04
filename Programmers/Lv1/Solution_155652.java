package Lv1;

import java.util.Set;
import java.util.stream.Collectors;

public class Solution_155652 {
	public static void main(String[] args) {
		String s = "aukks";
		String skip = "wbqd";
		int index = 5;

		System.out.println(solution(s, skip, index));
	}

	public static String solution(String s, String skip, int index) {
		// a : 97, z : 122 (Diff = 26)
		int[] strings = s.chars().toArray();
		Set<Integer> skips = skip.chars()
			.boxed()
			.collect(Collectors.toSet());

		StringBuilder sb = new StringBuilder();

		// 문자열을 반복하면서 한 글자씩 확인
		for (int i : strings) {

			// 인덱스만큼 확인
			for (int j = 0; j < index; j++) {
				i++;

				// 범위를 넘지 않았는지, 해당 문자가 포함되어 있는지 확인
				while (i > 122 || skips.contains(i)) {
					if (i > 122) {
						i -= 26;
					}

					if (skips.contains(i)) {
						i++;
					}
				}
			}

			sb.append((char)i);
		}

		return sb.toString();
	}
}
