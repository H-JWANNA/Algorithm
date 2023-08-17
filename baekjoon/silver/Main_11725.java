package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11725 {
	static ArrayList<Integer>[] input;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		input = new ArrayList[n + 1];
		parents = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			input[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			input[a].add(b);
			input[b].add(a);
		}

		makeTree(1);

		StringBuilder sb = new StringBuilder();

		for (int i = 2; i <= n; i++) {
			sb.append(parents[i]).append("\n");
		}

		System.out.print(sb);
	}

	static void makeTree(int node) {
		for (Integer i : input[node]) {
			if (parents[node] == i){
				continue;
			}

			parents[i] = node;
			makeTree(i);
		}
	}
}
