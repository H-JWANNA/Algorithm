package silver;

import java.io.*;
import java.util.*;

public class Main_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine(), " ");

        int vertex = Integer.parseInt(st.nextToken());
        int degree = Integer.parseInt(st.nextToken());

        int[][] adjList = new int[vertex + 1][vertex + 1];

        // 친구 관계 수를 입력 받아 양방향 인접리스트 생성
        for (int i = 0; i < degree; i++) {
            StringTokenizer st2 = new StringTokenizer(input.readLine(), " ");
            int first = Integer.parseInt(st2.nextToken());
            int second = Integer.parseInt(st2.nextToken());
            adjList[first][second] = 1;
            adjList[second][first] = 1;
        }

        // 케빈 베이컨 수를 담을 배열 생성
        int[] kevin = new int[vertex + 1];

        // 각 유저의 케빈 베이컨 수를 탐색
        for (int i = 1; i <= vertex; i++) {

            for (int j = 1; j <= vertex; j++) {
                // 자기 자신 탐색 X
                if(i == j) continue;

                boolean[] visited = new boolean[vertex + 1];

                kevin[i] += bfs(visited, adjList, i, j);
            }
        }

        // 최소값 출력
        int minKevin = 101;
        int index = 0;

        for (int i = 1; i < kevin.length; i++) {
            if(kevin[i] < minKevin) {
                minKevin = kevin[i];
                index = i;
            }
        }
        System.out.println(index);
    }

    public static int bfs(boolean[] visited, int[][] adjList, int from, int to){
        Queue<Integer> q = new LinkedList<>();
        visited[from] = true;
        q.offer(from);
        // 케빈 베이컨 수를 담을 cnt 배열 생성
        int[] cnt = new int[adjList.length];

        while (!q.isEmpty()) {
            int current = q.poll();
            // 해당 to 노드에 도착했다면 종료
            if(current == to) break;

            for (int i = 0; i < adjList.length; i++) {
                // 만약 이어진 간선이 없고 이미 방문한 곳이라면 건너뛰기
                if(adjList[current][i] == 1 && !visited[i]) {
                    // 아니라면 bfs 탐색하고 숫자 증가
                    q.offer(i);
                    visited[i] = true;
                    cnt[i] = cnt[current] + 1;
                }
            }
        }

        return cnt[to];
    }
}
