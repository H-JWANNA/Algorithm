package Lv1;

public class Solution_134240 {
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 4, 6};
		int[] arr2 = {1, 7, 1, 2};

		System.out.println(solution(arr1));
		System.out.println(solution(arr2));
	}

	public static String solution(int[] food) {
		StringBuilder sb = new StringBuilder();
		StringBuilder answer = new StringBuilder();

		// 음식 종류만큼 반복
		for (int i = 1; i < food.length; i++) {
			// 음식 갯수만큼 반복 (2개 이상일 때만)
			for (int j = 0; j < food[i]/2; j++) {
				sb.append(i);
			}
		}

		answer.append(sb);
		answer.append(0);
		answer.append(sb.reverse());

		return answer.toString();
	}
}
