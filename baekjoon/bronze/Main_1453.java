package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1453 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int guests = Integer.parseInt(br.readLine());
		String[] seats = br.readLine().split(" ");
		boolean[] visited = new boolean[101];
		int count = 0;

		for (String seat : seats) {
			int idx = Integer.parseInt(seat);

			if (visited[idx])
				count++;

			visited[idx] = true;
		}

		System.out.println(count);
	}
}
