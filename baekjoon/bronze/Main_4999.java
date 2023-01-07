package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4999 {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		String me = input.readLine();
		String dr = input.readLine();

		String answer = me.length() >= dr.length() ? "go" : "no";

		System.out.println(answer);
	}
}
