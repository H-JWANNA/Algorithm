package Lv1;

import java.util.Arrays;

public class Solution_42748 {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};

		System.out.println(Arrays.toString(solution(array, commands)));
	}

	public static int[] solution(int[] array, int[][] commands) {
		int len = commands.length;
		int[] arr = new int[len];

		for (int i = 0; i < len; i++) {
			// 자르기
			int[] crop = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);

			// 정렬
			Arrays.sort(crop);

			// 해당 숫자 정답에 집어 넣기
			arr[i] = crop[commands[i][2] - 1];
		}

		return arr;
	}
}
