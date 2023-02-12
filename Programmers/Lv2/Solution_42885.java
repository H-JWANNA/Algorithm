package Lv2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_42885 {
	public static void main(String[] args) {
		int[] people1 = {70, 50, 80, 50};
		int[] people2 = {70, 80, 50};
		int limit = 100;

		System.out.println(solution(people1, limit));
		System.out.println(solution(people2, limit));
	}

	public static int solution(int[] people, int limit) {
		// 그리디 알고리즘을 적용하기 위한 정렬
		Arrays.sort(people);

		// 양쪽에서 값을 삭제하기 위한 Deque 사용
		Deque<Integer> q = new ArrayDeque<>(50001);
		for (int i : people) {
			q.add(i);
		}

		int count = 0;

		while (!q.isEmpty()) {
			// 일단 가장 무거운 사람을 태운다
			int weight = limit - q.pollLast();

			// 만약 남은 무게가 가장 가벼운 사람보다 크면, 가장 가벼운 사람을 태운다
			if (!q.isEmpty() && weight >= q.peekFirst()) {
				q.pollFirst();
			}

			count++;
		}

		return count;
	}
}
