package Lv1;

import java.util.Arrays;

public class Solution_12982 {
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 2, 5, 4};
		int[] arr2 = {2, 2, 3, 3};

		int budget1 = 9;
		int budget2 = 10;

		System.out.println(solution(arr1, budget1));
		System.out.println(solution(arr2, budget2));
	}

	public static int solution(int[] d, int budget) {
		// 정답을 저장하기 위한 변수
		int answer = 0;

		// 그리디 알고리즘을 적용하기 위해 배열을 정렬
		Arrays.sort(d);

		// 뒷 순서부터 반복하며 최대 갯수 구하기
		for (int i = d.length - 1; i >= 0; i--) {
			// 반복을 위해 예산 초기화
			int b = budget;
			int count = 0;
			int index = i;

			// 예산이 없어질 때 까지 반복하며 갯수 세기
			while (b >= d[index]) {
				b -= d[index];
				count++;
				index--;

				// 탈출 조건
				if (index < 0) break;
			}

			// 가장 큰 값 저장
			answer = Math.max(answer, count);
		}

		return answer;
	}
}
