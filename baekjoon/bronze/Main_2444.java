package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2444 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			System.out.print(" ".repeat(n - i));
			System.out.println("*".repeat(i + (i - 1)));
		}

		for (int i = n - 1; i >= 1; i--) {
			System.out.print(" ".repeat(n - i));
			System.out.println("*".repeat(i + (i - 1)));
		}
	}
}
