package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		String[] words = new String[n];

		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}

		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 길이가 다른 경우에는 길이 순으로 정렬, 길이가 같은 경우에는 오름차순으로 정렬
				return o1.length() != o2.length() ? o1.length() - o2.length() : o1.compareTo(o2);
			}
		});

		sb.append(words[0]).append("\n");

		for (int i = 1; i < n; i++) {
			// 중복 제거
			if (!words[i].equals(words[i - 1])) {
				sb.append(words[i]).append("\n");
			}
		}

		System.out.println(sb);
	}
}
