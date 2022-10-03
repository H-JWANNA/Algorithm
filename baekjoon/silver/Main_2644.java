package silver;

import java.io.*;
import java.util.*;


public class Main_2644 {
    static int result = -1; // default = -1

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int vertex = Integer.parseInt(input.readLine());

        StringTokenizer st = new StringTokenizer(input.readLine(), " ");
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        // adjList 만들기
        int[][] adjList = new int[vertex + 1][vertex + 1];
        int degree = Integer.parseInt(input.readLine());
        for (int i = 0; i < degree; i++) {
            StringTokenizer st2 = new StringTokenizer(input.readLine(), " ");
            int row = Integer.parseInt(st2.nextToken());
            int column = Integer.parseInt(st2.nextToken());

            adjList[row][column] = 1;
            adjList[column][row] = 1;
        }

        // 방문 여부 배열
        boolean[] visited = new boolean[vertex + 1];

        // dfs 탐색
        dfs(visited, adjList, first, second, 0);
        System.out.println(result);
    }

    public static void dfs(boolean[] visited, int[][] adjList, int from, int to, int count) {
        // 방문 여부
        visited[from] = true;

        // 종료 조건
        if (from == to) {
            result = count;
            return;
        }

        for (int i = 0; i < adjList[from].length; i++) {
            if (from == i) continue;
            if (adjList[from][i] == 0 || visited[i]) continue;

            dfs(visited, adjList, i, to, count + 1);
        }
    }
}
