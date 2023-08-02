package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1865 {
	static long INF = Long.MAX_VALUE;
	static ArrayList<Road> roads;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		int n, m, w;

		/*
			n : 지점의 수 (Vertex)
			m : 도로의 수 (Edge)
			w : 웜홀의 갯수
		 */

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			int s, e, t;
			roads = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				roads.add(new Road(s, e, t));
				roads.add(new Road(e, s, t));
			}

			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				roads.add(new Road(s, e, -t));
			}

			boolean answer = false;

			for (int i = 1; i <= n; i++) {
				answer = bellmanFord(i, n);

				if (answer) {
					break;
				}
			}

			sb.append(answer ? "YES" : "NO").append("\n");
		}

		System.out.print(sb);
	}

	private static boolean bellmanFord(int start, int n) {
		long[] times = new long[n + 1];
		Arrays.fill(times, INF);
		times[start] = 0;
		boolean isUpdate = false;

		// 지점의 수 - 1 만큼 최단거리 초기화 반복
		for (int i = 1; i < n; i++) {
			isUpdate = false;

			// 모든 경로 탐색
			for (Road road : roads) {
				// 경로가 없다면 건너뛴다.
				if (times[road.start] == INF) {
					continue;
				}

				long newTime = times[road.start] + road.time;

				// 기존 경로의 시간이 새로운 경로보다 오래 걸린다면 갱신한다.
				if (times[road.end] > newTime) {
					times[road.end] = newTime;
					isUpdate = true;
				}
			}

			// 더 이상 최단 거리 초기화가 일어나지 않을 경우 종료
			if (!isUpdate) {
				break;
			}
		}

		// 한 번 더 업데이트가 발생하면 음수 사이클
		if (isUpdate) {
			for (int i = 1; i <= n; i++) {
				for (Road road : roads) {
					if (times[road.start] == INF) {
						continue;
					}

					if (times[road.end] > times[road.start] + road.time) {
						return true;
					}
				}
			}
		}

		return false;
	}

	static class Road {
		int start;
		int end;
		int time;

		public Road(int start, int end, int time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}
}
