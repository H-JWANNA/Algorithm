package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16173 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		int[][] board = new int[n][n];
		boolean[][] visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.print(jellyDFS(board, 0, 0, visited) ? "HaruHaru" : "Hing");
	}

	// DFS
	private static boolean jellyDFS(int[][] board, int i, int j, boolean[][] visited) {
		int len = board.length;
		int jump = board[i][j];
		visited[i][j] = true;

		// 목적지 도착
		if (jump == -1) {
			return true;
		}

		boolean isPossible = false;

		int nextI = i + jump;
		int nextJ = j + jump;

		if (nextI < len && !visited[nextI][j]) {
			isPossible = jellyDFS(board, nextI, j, visited);
		}

		if (nextJ < len && !visited[i][nextJ]) {
			isPossible |= jellyDFS(board, i, nextJ, visited);
		}

		return isPossible;
	}
}
