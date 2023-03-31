package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main_2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ArrayList.remove()는 시간 복잡도가 O(n)
		// LinkedList.remove()는 시간 복잡도가 O(1)
		List<Integer> cards = new LinkedList<>();

		int n = Integer.parseInt(br.readLine());

		// 카드 입력
		for (int i = 1; i <= n; i++) {
			cards.add(i);
		}

		while (cards.size() > 1) {
			// 가장 위의 카드를 버린다
			cards.remove(0);

			// 2번째 카드를 아래로 옮긴다
			cards.add(cards.remove(0));
		}

		System.out.println(cards.get(0));
	}
}
