package Lv2;

import java.util.*;

public class Solution_42587 {
	public int solution(int[] priorities, int location) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for(int i : priorities) {
			pq.add(i);
		}

		int index = -1;
		int answer = 0;

		while(!pq.isEmpty()) {
			int cur = pq.poll();

			while(true) {
				if (index == priorities.length - 1) {
					index = -1;
				}

				index++;

				if (cur == priorities[index]) {
					answer++;

					if (index == location) {
						return answer;
					}

					break;
				}
			}
		}

		return answer;
	}
}
