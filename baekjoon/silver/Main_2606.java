package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606 {
	static boolean[][] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());

		adjList = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];
		visited[1] = true;

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			adjList[first][second] = true;
			adjList[second][first] = true;
		}

		System.out.println(search(1));
	}

	private static int search(int x) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(x);

		int count = 0;

		while (!q.isEmpty()) {
			int current = q.poll();
			count++;

			// 인접 리스트를 통해 연결된 모든 다음 컴퓨터 추가
			q.addAll(nextSearch(current));
		}

		// 1번 컴퓨터 제외
		return count - 1;
	}

	private static ArrayList<Integer> nextSearch(int x) {
		ArrayList<Integer> nextComputers = new ArrayList<>();

		for (int i = 1; i < adjList.length; i++) {
			if (adjList[x][i] && !visited[i]) {
				nextComputers.add(i);
				visited[i] = true;
			}
		}

		return nextComputers;
	}
}
