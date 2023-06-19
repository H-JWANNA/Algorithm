package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_10828_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		ArrayList<String> arr = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
				case "push":
					arr.add(st.nextToken());
					break;
				case "pop":
					sb.append(arr.isEmpty() ? -1 : arr.remove(arr.size() - 1)).append("\n");
					break;
				case "size":
					sb.append(arr.size()).append("\n");
					break;
				case "empty":
					sb.append(arr.size() == 0 ? 1 : 0).append("\n");
					break;
				case "top":
					sb.append(arr.isEmpty() ? -1 : arr.get(arr.size() - 1)).append("\n");
					break;
			}
		}

		System.out.println(sb);
	}
}
