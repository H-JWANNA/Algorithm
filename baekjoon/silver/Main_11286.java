package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> plusHeap = new PriorityQueue<>();
		PriorityQueue<Integer> minusHeap = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();

		while (n-- > 0) {
			int i = Integer.parseInt(br.readLine());

			if (i == 0) {
				// 둘 다 비었을 경우
				if (plusHeap.isEmpty() && minusHeap.isEmpty()) {
					sb.append(0).append("\n");
					continue;
				}
				// 둘 중 하나만 비었을 경우
				if (plusHeap.isEmpty()) {
					sb.append(minusHeap.poll()).append("\n");
					continue;
				}

				if (minusHeap.isEmpty()) {
					sb.append(plusHeap.poll()).append("\n");
					continue;
				}

				// 둘 다 값이 있을 경우
				int p = plusHeap.peek();
				int m = Math.abs(minusHeap.peek());

				sb.append(m > p ? plusHeap.poll() : minusHeap.poll()).append("\n");
			}
			// 0이 아닌 정수인 경우 plus, minus 에 나눠서 삽입한다.
			else if (i > 0) {
				plusHeap.add(i);
			} else {
				minusHeap.add(i);
			}
		}

		System.out.print(sb);
	}
}
