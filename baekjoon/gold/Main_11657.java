package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11657 {
	static ArrayList<Path> paths;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		paths = new ArrayList<>();

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			paths.add(new Path(a, b, c));
		}

		long[] times = bellmanFord(n, 1);

		StringBuilder sb = new StringBuilder();

		if (times.length < 2) {
			System.out.print(-1);
		} else {
			for (int i = 2; i <= n; i++) {
				sb.append(times[i] == Long.MAX_VALUE ? -1 : times[i]).append("\n");
			}

			System.out.print(sb);
		}
	}

	private static long[] bellmanFord(int n, int start) {
		// 총 시간 초기화
		long[] times = new long[n + 1];
		Arrays.fill(times, Long.MAX_VALUE);
		times[start] = 0;

		// 도시의 수만큼 반복한다.
		for (int i = 1; i <= n; i++) {
			// 모든 경로를 탐색한다.
			for (Path path : paths) {
				// 경로가 없다면 건너뛴다.
				if (times[path.from] == Long.MAX_VALUE)
					continue;

				// 기존 경로의 시간이 새로운 경로보다 오래 걸린다면 갱신한다.
				if (times[path.to] > times[path.from] + path.time) {
					// n번 째에도 갱신이 계속된다면 음의 사이클이 존재하는 것이다.
					if (i == n) {
						return new long[] {};
					}

					times[path.to] = times[path.from] + path.time;
				}
			}
		}

		return times;
	}

	static class Path {
		int from;
		int to;
		int time;

		public Path(int from, int to, int time) {
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}
}
