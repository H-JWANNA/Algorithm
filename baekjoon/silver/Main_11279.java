package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 최대 힙을 구하기 위해서는 역순으로 정렬된 우선순위 큐가 필요하다.
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();

		while (n-- > 0) {
			int i = Integer.parseInt(br.readLine());

			if (i == 0) {
				sb.append(heap.isEmpty() ? 0 : heap.poll()).append("\n");
			} else {
				heap.add(i);
			}
		}

		System.out.print(sb);
	}
}
