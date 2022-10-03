package silver;

import java.io.*;
import java.util.*;

public class Main_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine(), " ");

        int vertex = Integer.parseInt(st.nextToken());
        int degree = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());

        // 방문 여부를 저장할 배열
        boolean[] dfsvisited = new boolean[vertex + 1];
        boolean[] bfsvisited = new boolean[vertex + 1];

        // 인접 리스트 생성
        int[][] adjList = new int[vertex + 1][vertex + 1];
        for (int i = 0; i < degree; i++) {
            StringTokenizer node = new StringTokenizer(input.readLine(), " ");
            int row = Integer.parseInt(node.nextToken());
            int column = Integer.parseInt(node.nextToken());

            // 양방향 간선
            adjList[row][column] = 1;
            adjList[column][row] = 1;
        }

        // 정답을 담을 배열 생성
        ArrayList<Integer> dfsResult = new ArrayList<>();
        ArrayList<Integer> bfsResult = new ArrayList<>();

        dfs(dfsvisited, adjList, root, dfsResult);
        bfs(bfsvisited, adjList, root, bfsResult);

        for (int i = 0; i < dfsResult.size(); i++) {
            System.out.print(dfsResult.get(i));
            if(i != (dfsResult.size() - 1) ) System.out.print(" ");
        }
        System.out.println("");
        for (int i = 0; i < bfsResult.size(); i++) {
            System.out.print(bfsResult.get(i));
            if(i != (bfsResult.size() - 1) ) System.out.print(" ");
        }
    }

    // DFS : 방문 여부 배열 / 인접리스트 / 현재 방문 중인 노드 / 정답을 담을 배열
    public static ArrayList<Integer> dfs(boolean[] visited, int[][] adjList, int root, ArrayList<Integer> dfsResult) {
        // 방문도장 찍기
        visited[root] = true;
        // 탐색한 노드 정보를 입력
        dfsResult.add(root);

        // adjList root 번째 row 의 column 순회
        for (int i = 0; i < adjList[root].length; i++) {
            // 자기 자신 반복 금지
            if(root == i) continue;
            // 만약 adjList 값이 0이거나 방문을 이미 했으면 continue
            if(adjList[root][i] == 0 || visited[i]) continue;

            // 아니라면 i 에 해당하는 번호의 row 순회
            dfs(visited, adjList, i, dfsResult);
        }
        return dfsResult;
    }

    // BFS : 방문 여부 배열 / 인접리스트 / 현재 방문 중인 노드 / 정답을 담을 배열
    public static ArrayList<Integer> bfs(boolean[] visited, int[][] adjList, int root, ArrayList<Integer> bfsResult) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        // q가 빌 때까지 반복
        while(!q.isEmpty()) {
            int current = q.poll();
            // 같은 값이 연속으로 들어오는 것을 방지
            if(!visited[current]) bfsResult.add(current);
            // 방문도장 찍기
            visited[current] = true;

            // adjList current 번째 row 의 column 순회
            for (int i = 0; i < adjList[current].length; i++) {
                // 자기 자신 반복 금지
                if(current == i) continue;

                // 만약 adjList 값이 0이거나 방문을 이미 했으면 continue
                if(adjList[current][i] == 0 || visited[i]) continue;

                // 아니라면 q에 i 값 추가해서 반복
                q.offer(i);
            }
        }
        return bfsResult;
    }
}
