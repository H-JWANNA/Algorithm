package Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution_154540 {
	public static void main(String[] args) {
		String[] map1 = {"X591X", "X1X5X", "X231X", "1XXX1"};
		String[] map2 = {"XXX", "XXX", "XXX"};

		System.out.println(Arrays.toString(solution(map1)));
		System.out.println(Arrays.toString(solution(map2)));
	}

	public static int[] solution(String[] maps) {

		int y = maps.length;
		int x = maps[0].length();

		boolean[][] visited = new boolean[y][x];
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				int count = search(visited, maps, j, i);
				System.out.println("== Search Complete == x : " + j + " and y : " + i);

				if (count > 0) {
					System.out.println("add count = " + count);
					System.out.println("add count x = " + j);
					System.out.println("add count y = " + i);
					result.add(count);
				}
			}
		}

		Collections.sort(result);

		return result.size() == 0 ? new int[] {-1} : result.stream().mapToInt(i -> i).toArray();
	}

	private static int search(boolean[][] visited, String[] maps, int x, int y) {

		// 길이 있는지 확인
		if (x < 0 || y < 0 || x >= maps[0].length() || y >= maps.length) {
			System.out.println("block 1");
			return 0;
		}

		System.out.println("pass1");

		// 올바른 길인지, 이미 방문했는지 확인
		if (maps[y].charAt(x) == 'X' || visited[y][x]) {
			System.out.println("block 2");
			return 0;
		}

		System.out.println("pass2");

		// 방문 여부 체크
		visited[y][x] = true;

		int count = maps[y].charAt(x) - '0';

		// 각 방향 탐색
		count += search(visited, maps, x + 1, y);
		count += search(visited, maps, x - 1, y);
		count += search(visited, maps, x, y + 1);
		count += search(visited, maps, x, y - 1);

		System.out.println("=".repeat(30));
		System.out.println("count = " + count);
		System.out.println("x = " + x);
		System.out.println("y = " + y);

		return count;
	}
}
