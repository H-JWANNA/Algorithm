package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());   // 정점 갯수
        int m = Integer.parseInt(st.nextToken());   // 간선 갯수
        int result = 0; // 연결 요소의 갯수

        // 인접 리스트 생성 (무향 그래프 = 양방향 그래프)
        int[][] adjList = new int[n][n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(input.readLine());
            int num1 = Integer.parseInt(st2.nextToken());
            int num2 = Integer.parseInt(st2.nextToken());
            adjList[num1 - 1][num2 - 1] = 1;
            adjList[num2 - 1][num1 - 1] = 1;
        }
//        System.out.println(Arrays.deepToString(adjList));

        // 방문여부 확인
        boolean[] visited = new boolean[n];

        // 끝까지 전부 순회해야하니 반복문
        for (int i = 0; i < n; i++) {
            // 만약 방문했으면 재귀 실행 안하게
            if (visited[i]) continue;

            dfs(visited, adjList, i);
            // 방문이 끝났다면 카운트 1씩 올려주기
            result += 1;
        }
        System.out.println(result);
    }

    // 인접리스트를 활용한 dfs
    public static void dfs(boolean[] visited, int[][] adjList, int root) {
        // 방문도장 찍기
        visited[root] = true;

        // adjList 순회하기
        for (int i = 0; i < adjList[root].length; i++) {
            // 만약 해당 노드가 1이고 방문 안했으면 깊이 순회해보기
            if (adjList[root][i] == 1 && !visited[i]) {
//                System.out.println("root 에서 i로 탐색= " + root + ", " + i);
                dfs(visited, adjList, i);
            }
        }
//        System.out.println("이번방문은 = " + Arrays.toString(visited));
    }
}
