package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main_1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String s = br.readLine();

			// 탈출 조건
			if (Objects.equals(s, "0")) {
				break;
			}

			// 뒤집힌 수 만들기
			String palindrome = new StringBuilder(s).reverse().toString();

			if (Objects.equals(s, palindrome)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
