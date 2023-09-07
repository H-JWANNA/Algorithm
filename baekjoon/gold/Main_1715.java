package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

		int answer = 0;

		while (n-- > 0) {
			int card = Integer.parseInt(br.readLine());
			pq.add(card);
		}

		while (pq.size() > 1) {
			int first = pq.poll();
			int second = pq.poll();
			int sum = first + second;

			answer += sum;

			pq.add(sum);
		}

		System.out.println(answer);
	}
}
