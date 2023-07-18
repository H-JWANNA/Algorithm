package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	메모리 : 34356KB
	시간 : 368ms
 */

public class Main_20922 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		int[] counts = new int[100001];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;

		/*
		 	우측 포인터를 이동시키며 counts 배열에 정수의 갯수를 입력한다.
		 	counts 배열의 정수가 K를 초과한다면,
		 	우측 포인터는 멈추고, 좌측 포인터를 이동시키면서 counts 배열에 정수의 갯수를 줄여나간다.
		 	각 작업 시에 길이를 구하여 max 길이를 측정한다.
		 */

		int len = 0;

		while (left <= right && right < n) {
			int lastNum = arr[right];

			if (counts[lastNum] >= k) {
				int firstNum = arr[left];
				counts[firstNum] -= 1;
				left++;
			} else {
				counts[lastNum] += 1;
				right++;
			}

			len = Math.max(len, right - left);
		}

		System.out.println(len);
	}
}
