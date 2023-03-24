package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1978 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] primes = new int[n];

		for (int i = 0; i < n; i++) {
			primes[i] = Integer.parseInt(st.nextToken());
		}

		// 수를 모아놓은 배열에서 소수만 찾아서 카운트한다.
		long answer = Arrays.stream(primes)
			.filter(i -> isPrime(i))
			.count();

		System.out.println(answer);
	}

	private static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}

		int i = 2;

		// 자기 자신의 제곱근까지 나누었을 때 나누어 떨어지지 않으면 소수이다.
		while (i <= Math.pow(num, 0.5)) {
			if (num % i == 0) {
				return false;
			}

			i += 1;
		}

		return true;
	}
}
