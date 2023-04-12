package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4963 {
	static int[][] map;
	static boolean[][] visited;

	// 상 하 좌 우 좌상 우상 좌하 우하
	static int[] dw = new int[] {0, 0, -1, 1, -1, 1, -1, 1};
	static int[] dh = new int[] {-1, 1, 0, 0, -1, -1, 1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			// 종료 조건
			if (w == 0 && h == 0) {
				break;
			}

			// 섬 입력
			map = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int island = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					// 전 맵 탐방하기
					if (!visited[i][j] && map[i][j] == 1) {
						island++;
						dfs(i, j);
					}
				}
			}

			sb.append(island).append("\n");
		}

		System.out.println(sb);
	}

	// DFS
	private static void dfs(int h, int w) {
		// 방문 도장 찍기
		visited[h][w] = true;

		// 전 방향 탐색
		for (int i = 0; i < 8; i++) {
			int nextH = h + dh[i];
			int nextW = w + dw[i];

			// 맵 밖으로 나가면 안됨, 이미 방문한 곳은 안됨, 다음 갈 곳에 섬이 있어야함
			if (isOut(visited.length, visited[0].length, nextH, nextW)) continue;
			if (visited[nextH][nextW]) continue;
			if (map[nextH][nextW] == 0) continue;

			dfs(nextH, nextW);
		}
	}

	private static boolean isOut(int h, int w, int nextH, int nextW) {
		return nextH < 0 || nextW < 0 || nextH > h - 1 || nextW > w - 1;
	}
}
