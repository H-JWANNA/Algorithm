package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main_2083 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] s = br.readLine().split(" ");

			if (Objects.equals(s[0], "#")) {
				System.exit(0);
			}

			StringBuilder sb = new StringBuilder();
			sb.append(s[0]);

			if (Integer.parseInt(s[1]) > 17 || Integer.parseInt(s[2]) >= 80) {
				sb.append(" Senior");
			} else {
				sb.append(" Junior");
			}

			System.out.println(sb);
		}
	}
}
