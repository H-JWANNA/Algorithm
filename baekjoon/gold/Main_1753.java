package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {
	static ArrayList<int[]>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		arr = new ArrayList[v + 1];

		for (int i = 1; i <= v; i++) {
			arr[i] = new ArrayList<>();
		}

		while (e-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			// 배열의 출발 인덱스에 도착지와 가중치를 입력한다.
			arr[from].add(new int[] {to, w});
		}

		int[] distances = dijkstra(v, start);
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= v; i++) {
			if (distances[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(distances[i]).append("\n");
			}
		}

		System.out.print(sb);
	}

	private static int[] dijkstra(int v, int start) {
		boolean[] visited = new boolean[v + 1];
		int[] distance = new int[v + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		// 가중치가 낮은 순으로 정렬하는 우선순위 큐를 생성한다.
		PriorityQueue<int[]> pq = new PriorityQueue<>(
			(a1, a2) -> a1[1] == a2[1] ? a1[0] - a2[0] : a1[1] - a2[1]);

		pq.add(new int[] {start, 0});

		while (!pq.isEmpty()) {
			int curV = pq.poll()[0];

			if (visited[curV])
				continue;
			visited[curV] = true;

			/*
				시작 정점에서 이어지는 정점 간의 가중치 합이 기존 가중치보다 작은 값일 경우 교체한다.

				만약 기존 가중치보다 크다면 더 이상 탐색할 필요가 없지만,
				작은 값일 경우 다음 정점에 대한 가중치 합까지 계산해볼 가치가 있으므로 우선순위 큐에 넣는다.
			 */
			for (int[] a : arr[curV]) {
				int nextV = a[0];
				int nextW = a[1];

				if (distance[nextV] > distance[curV] + nextW) {
					distance[nextV] = distance[curV] + nextW;
					pq.add(new int[] {nextV, distance[nextV]});
				}
			}
		}

		return distance;
	}
}
