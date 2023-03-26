package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 정답을 출력할 Map (key : 카드 번호, value : 갯수)
		Map<String, Integer> map = new HashMap<>();

		// 입력
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			String card = st.nextToken();
			// 처음 나온 카드라면 1, 아니라면 현재 갯수 + 1
			map.put(card, map.containsKey(card) ? map.get(card) + 1 : 1);
		}

		// 입력2
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		String[] numbers = new String[m];

		for (int i = 0; i < m; i++) {
			numbers[i] = st.nextToken();
		}

		// 순차적으로 갯수 출력 (없을 경우 기본값 0)
		for (String num : numbers) {
			sb.append(map.getOrDefault(num, 0)).append(" ");
		}

		System.out.println(sb);
	}
}
