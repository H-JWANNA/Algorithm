package Lv2;

import java.util.*;

public class Solution_42626 {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i : scoville) {
			pq.add(i);
		}

		int cnt = 0;

		while(pq.size() > 1) {
			int first = pq.poll();

			if (first >= K) {
				break;
			}

			int second = pq.poll();

			pq.add(first + second * 2);
			cnt++;
		}

		return pq.peek() < K ? -1 : cnt;
	}
}
