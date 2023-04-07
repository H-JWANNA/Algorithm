package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(input.readLine());

		// 공집합 S 생성
		boolean[] s = new boolean[21];

		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(input.readLine());

			switch (st.nextToken()) {
				case "add":
					s[parseInt(st.nextToken())] = true;
					break;
				case "remove":
					s[parseInt(st.nextToken())] = false;
					break;
				case "check":
					sb.append(s[parseInt(st.nextToken())] ? 1 : 0).append("\n");
					break;
				case "toggle":
					int toggleNum = parseInt(st.nextToken());
					s[toggleNum] = !s[toggleNum];
					break;
				case "all":
					Arrays.fill(s, true);
					break;
				case "empty":
					Arrays.fill(s, false);
					break;
			}
		}
		input.close();

		System.out.println(sb);
	}

	private static int parseInt(String token) {
		return Integer.parseInt(token);
	}
}
