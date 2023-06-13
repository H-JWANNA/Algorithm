package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		/*
			1. 기존 배열을 정렬 및 중복 제거한 배열을 만든다.
			2. 기존 배열의 값이 중복 제거한 배열의 몇 번째 인덱스인지 확인한다.
		 */

		int[] arr = new int[n];
		int[] answer = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] sortedArr = Arrays.stream(arr)
			.sorted()
			.distinct()
			.toArray();

		for (int i = 0; i < n; i++) {
			answer[i] = Arrays.binarySearch(sortedArr, arr[i]);
		}

		StringBuilder sb = new StringBuilder();

		for (int i : answer) {
			sb.append(i).append(" ");
		}

		System.out.println(sb);
	}
}
