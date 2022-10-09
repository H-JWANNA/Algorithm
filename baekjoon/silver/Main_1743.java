package silver;

import java.io.*;
import java.util.*;

public class Main_1743 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine(), " ");
        int y_axis = Integer.parseInt(st.nextToken());
        int x_axis = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[y_axis + 1][x_axis + 1];
        boolean[][] visited = new boolean[y_axis + 1][x_axis + 1];

        for (int i = 0; i < k; i++) {
            StringTokenizer st2 = new StringTokenizer(input.readLine(), " ");
            int r = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            map[r][c] = 1;
        }

        int result = 1;

        // 꼼꼼하게 체크하기
        for (int i = 1; i <= y_axis; i++) {
            for (int j = 1; j <= x_axis; j++) {
                if(map[i][j] == 0 || visited[i][j]) continue;

                result = Math.max(result, bfs(visited, map, j, i));
            }
        }

        System.out.println(result);
    }

    public static int bfs(boolean[][] visited, int[][] map, int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {y, x});
        visited[y][x] = true;

        int count = 1;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        while(!q.isEmpty()) {
            int[] current = q.poll();

            // 상하좌우 한번씩 스캔
            for (int i = 0; i < 4; i++) {
                int next_y = current[0] + dy[i];
                int next_x = current[1] + dx[i];

                // 범위 밖이면 continue
                if(next_x < 0 || next_y < 0
                        || next_x >= map[0].length || next_y >= map.length) continue;

                // 조건에 부합하면 탐색
                if(map[next_y][next_x] == 1 && !visited[next_y][next_x]) {
                    visited[next_y][next_x] = true;
                    count++;
                    q.offer(new int[] {next_y, next_x});
                }
            }
        }

        return count;
    }
}
