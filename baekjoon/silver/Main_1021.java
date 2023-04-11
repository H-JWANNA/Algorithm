package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Deque<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		st = new StringTokenizer(br.readLine());

		DeckAndCount dc = new DeckAndCount(q, 0);

		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());

			// count 값이 최소가 되는 DeckAndCount 클래스를 선택
			DeckAndCount leftDC = moveLeft(dc, target);
			DeckAndCount rightDC = moveRight(dc, target);
			dc = leftDC.getCount() <= rightDC.getCount() ? leftDC : rightDC;
		}

		System.out.println(dc.getCount());
	}

	private static DeckAndCount moveLeft(DeckAndCount dc, int target) {
		Deque<Integer> q = new ArrayDeque<>(dc.getQ());
		int count = dc.getCount();

		while (q.size() > 1) {
			int num = q.pollFirst();

			// 탈출 조건
			if (num == target)
				break;

			// 아니라면 맨 뒤에 값을 넣고 다시 반복한다.
			q.addLast(num);
			count++;
		}

		return new DeckAndCount(q, count);
	}

	private static DeckAndCount moveRight(DeckAndCount dc, int target) {
		Deque<Integer> q = new ArrayDeque<>(dc.getQ());
		int count = dc.getCount();

		while (q.size() > 1) {
			int num = q.pollLast();

			// 탈출 조건
			if (num == target)
				break;

			// 아니라면 맨 앞에 값을 넣고 다시 반복한다.
			q.addFirst(num);
			count++;
		}

		// 맨 뒤 값이 count 이므로 앞으로 오는 것 까지 계산해서 +1
		return new DeckAndCount(q, count + 1);
	}
}

class DeckAndCount {
	private Deque<Integer> q;
	private int count;

	public DeckAndCount(Deque<Integer> q, int count) {
		this.q = q;
		this.count = count;
	}

	public Deque<Integer> getQ() {
		return q;
	}

	public int getCount() {
		return count;
	}

	public void setQ(Deque<Integer> q) {
		this.q = q;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
