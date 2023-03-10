package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int gcd = gcd(a, b);
		// int gcd = gcd2(a, b);

		// 최대 공약수 (GCD)
		System.out.println(gcd);

		// 최소 공배수 (LCM)
		System.out.println((a * b) / gcd);
	}

	// 유클리드 호제법 (재귀)
	// 메모리 : 11520KB, 시간 : 76ms
	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}

	// 유클리드 호제법 (반복문)
	// 메모리 : 11524KB, 시간 : 80ms
	private static int gcd2(int a, int b) {
		while (b != 0) {
			int remain = a % b;
			a = b;
			b = remain;
		}

		return a;
	}
}
