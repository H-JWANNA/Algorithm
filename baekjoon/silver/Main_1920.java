package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// Set의 contains() 시간 복잡도는 O(1)
		Set<String> set = new HashSet<>();

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			set.add(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			sb.append(set.contains(st.nextToken()) ? 1 : 0).append("\n");
		}

		System.out.println(sb);
	}
}
