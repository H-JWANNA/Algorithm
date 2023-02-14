package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.') {
				sb.append(poly(count));

				count = 0;
				sb.append(".");
			}

			if (str.charAt(i) == 'X') {
				count++;
			}
		}

		sb.append(poly(count));

		System.out.println(sb);
	}

	private static String poly(int count) {
		StringBuilder sb = new StringBuilder();

		if (count % 2 == 1) {
			System.out.println(-1);
			System.exit(0);
		}

		while (count >= 4) {
			sb.append("AAAA");
			count -= 4;
		}

		if (count == 2) {
			sb.append("BB");
			count -= 2;
		}

		return sb.toString();
	}

	/*
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = str.split("\\.");
		StringBuilder sb = new StringBuilder();

		for (String s : arr) {
			sb.append(".");
			int len = s.length();

			if (len % 2 == 1) {
				break;
			}

			if (len == 0) {
				continue;
			}

			while (len >= 4) {
				sb.append("AAAA");
				len -= 4;
			}

			if (len == 2) {
				sb.append("BB");
			}
		}

		sb.deleteCharAt(0);

		System.out.println(sb.length() == str.length() ? sb : -1);
	}
	*/
}

