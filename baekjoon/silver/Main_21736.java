package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21736 {
    static char[][] campus;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        campus = new char[n][m];
        visited = new boolean[n][m];
        int[] start = new int[2];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                campus[i][j] = c;

                if (c == 'I') {
                    start = new int[]{j, i};
                }
            }
        }

        int count = bfs(start);

        System.out.println(count == 0 ? "TT" : count);
    }

    private static int bfs(int[] node) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(node);
        visited[node[1]][node[0]] = true;

        int count = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (isOut(nx, ny) || visited[ny][nx]) {
                    continue;
                }

                if (campus[ny][nx] == 'X') {
                    visited[ny][nx] = true;
                    continue;
                }

                if (campus[ny][nx] == 'P') {
                    count++;
                }

                q.add(new int[] {nx, ny});
                visited[ny][nx] = true;
            }
        }

        return count;
    }

    private static boolean isOut(int x, int y) {
        return x < 0 || y < 0 || x >= campus[0].length || y >= campus.length;
    }
}
