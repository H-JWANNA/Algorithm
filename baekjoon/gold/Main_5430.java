package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5430 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String func = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			st = new StringTokenizer(s.substring(1, s.length() - 1), ",");

			arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int start = 0;
			int end = n;
			boolean isReverse = false;

			for (int i = 0; i < func.length(); i++) {
				char op = func.charAt(i);

				switch (op) {
					case 'R':
						isReverse = !isReverse;
						break;
					case 'D':
						if (isReverse) {
							end--;
						} else {
							start++;
						}
						break;
				}
			}

			if (start > end) {
				sb.append("error").append("\n");
			} else {
				sb.append("[");

				if (isReverse) {
					for (int i = end - 1; i >= start; i--) {
						sb.append(arr[i]).append(",");
					}
				} else {
					for (int i = start; i < end; i++) {
						sb.append(arr[i]).append(",");
					}
				}

				if (sb.charAt(sb.length() - 1) == ',') {
					sb.deleteCharAt(sb.length() - 1);
				}

				sb.append("]").append("\n");
			}
		}

		System.out.print(sb);
	}
}
