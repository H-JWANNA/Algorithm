package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main_1264 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();

			// 종료 조건
			if (Objects.equals(str, "#")) break;

			str = str.toLowerCase();

			long count = str.chars()
				.filter(c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				.count();

			System.out.println(count);
		}
	}
}
