package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10250 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());

			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			// 층은 높이로 고객 순번을 나눈 나머지 값 (단, 나머지가 0일 경우는 최상층)
			sb.append(n % height == 0 ? height : n % height);

			// 호 수는 높이로 고객 순번을 나눈 몫 + 1 (단, 나누어 떨어지는 경우에는 1을 추가하지 않는다)
			int room = n % height == 0 ? n / height : n / height + 1;

			// 10 이하일 경우 앞에 0 추가
			sb.append(room < 10 ? "0" + room : room);
			sb.append("\n");
		}

		System.out.print(sb);
	}
}
