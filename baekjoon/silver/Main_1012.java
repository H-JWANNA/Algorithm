package silver;

import java.io.*;
import java.util.*;

public class Main_1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());

        // 테스트 케이스만큼 반복
        for (int t = 0; t < testCase; t++) {
            // 배추밭 생성
            StringTokenizer st = new StringTokenizer(input.readLine(), " ");
            int x_axis = Integer.parseInt(st.nextToken());
            int y_axis = Integer.parseInt(st.nextToken());

            int[][] map = new int[y_axis][x_axis];
            boolean[][] visited = new boolean[y_axis][x_axis];
            int count = 0;

            // 배추 심기
            int num = Integer.parseInt(st.nextToken());
            for (int seed = 0; seed < num; seed++) {
                StringTokenizer st2 = new StringTokenizer(input.readLine(), " ");
                int x_co = Integer.parseInt(st2.nextToken());
                int y_co = Integer.parseInt(st2.nextToken());
                map[y_co][x_co] = 1;
            }

            // 배추밭 탐색하기 (구석구석 꼼꼼히)
            for (int y = 0; y < y_axis; y++) {
                for (int x = 0; x < x_axis; x++) {
                    // 배추밭의 값이 0이거나, 이미 방문했다면 패스
                    if(map[y][x] == 0 || visited[y][x]) continue;

                    // 아니라면 탐색하고, 지렁이 갯수 올리기
                    bfs(x, y, map, visited);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    // X 좌표와 Y 좌표를 받아 BFS
    static void bfs(int x, int y, int[][] map, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y, x});
        visited[y][x] = true;

        // 이동할 좌표 생성
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 인접한 값이 없을 때 까지 반복
        while(!q.isEmpty()) {
            // 현재 노드 방문처리
            int[] current = q.poll();

//            visited[current[0]][current[1]] = true; >> 메모리 초과 ==========
            // 큐에서 뺀 뒤 방문 표시를 하게 되면
            // 여러 정점에서 한 정점을 같은 시간에 방문하려 할 때
            // 방문 표시가 계속 되어있지 않아 여러 번 큐에 들어가고,
            // 그 여러 번 들어간 정점이 나와서 주변의 정점을 또 여러 번 큐에 넣고... 하는 것을 반복하게 됩니다.
            // =================================================

            // 상하좌우 한번씩 스캔
            for (int i = 0; i < dx.length; i++) {
                int next_x = current[1] + dx[i];
                int next_y = current[0] + dy[i];

                // 스캔 범위가 배추밭 범위를 벗어나게 된다면 패스
                if(next_x < 0 || next_x >= map[0].length
                        || next_y < 0 || next_y >= map.length) continue;

                // 아니라면 탐색하는데, 해당 위치가 1이고 방문한 적이 없어야 한다.
                if(map[next_y][next_x] == 1 && !visited[next_y][next_x]) {
                    q.offer(new int[]{next_y, next_x});

                    //========== 해당 위치에 방문 표시 ==========
                    visited[next_y][next_x] = true;
                }
            }
        }
    }
}
