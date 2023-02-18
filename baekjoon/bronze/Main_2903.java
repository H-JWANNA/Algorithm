package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2903 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int init = 2;

		for (int i = 0; i < n; i++) {
			init += init - 1;
		}

		long answer = (long) Math.pow(init, 2);

		System.out.println(answer);
	}
}
