package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int pipes = 0;
		int answer = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				if (s.charAt(i + 1) == ')') {
					answer += pipes;
					i++;
				} else {
					pipes++;
				}
			} else {
				pipes--;
				answer++;
			}
		}

		System.out.println(answer);
	}
}
