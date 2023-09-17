package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {
	static int[][][] storage;
	static int[] dn = {-1, 1, 0, 0, 0, 0};
	static int[] dm = {0, 0, -1, 1, 0, 0};
	static int[] dh = {0, 0, 0, 0, -1, 1};

	static class Location {
		int n, m, h;

		public Location(int n, int m, int h) {
			this.n = n;
			this.m = m;
			this.h = h;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		storage = new int[H][N][M];

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());

				for (int m = 0; m < M; m++) {
					storage[h][n][m] = Integer.parseInt(st.nextToken());
				}
			}
		}

		bfs(N, M, H);

		int max = 0;

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (storage[h][n][m] == 0) {
						System.out.println(-1);
						return;
					}

					max = Math.max(max, storage[h][n][m]);
				}
			}
		}

		System.out.println(max - 1);
	}

	public static void bfs(int N, int M, int H) {
		Queue<Location> q = new ArrayDeque<>();

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (storage[h][n][m] == 1) {
						q.add(new Location(n, m, h));
					}
				}
			}
		}

		while (!q.isEmpty()) {
			Location location = q.poll();

			for (int i = 0; i < 6; i++) {
				int nn = location.n + dn[i];
				int nm = location.m + dm[i];
				int nh = location.h + dh[i];

				if (isOutOfRange(nn, nm, nh)) {
					continue;
				}

				if (storage[nh][nn][nm] == 0) {
					q.add(new Location(nn, nm, nh));
					storage[nh][nn][nm] = storage[location.h][location.n][location.m] + 1;
				}
			}
		}
	}

	public static boolean isOutOfRange(int n, int m, int h) {
		return h < 0 || n < 0 || m < 0 ||
			h >= storage.length || n >= storage[h].length || m >= storage[h][n].length;
	}
}
