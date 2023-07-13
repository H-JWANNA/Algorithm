package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_2178 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        bfs();

        System.out.println(map[n - 1][m - 1]);
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 밖인 경우
                if (isNext(nx, ny)) {
                    continue;
                }

                // 시작점인 경우 (시작점은 항상 1)
                if (nx == 0 && ny == 0) {
                    continue;
                }

                // 길이 아닌 경우와 이미 지난 길인 경우
                if (map[ny][nx] != 1) {
                    continue;
                }

                q.add(new int[]{nx, ny});
                map[ny][nx] = map[y][x] + 1;
            }
        }
    }

    private static boolean isNext(int x, int y) {
        return y < 0 || x < 0 || y >= map.length || x >= map[y].length;
    }
}
