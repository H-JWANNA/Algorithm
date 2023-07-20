package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	메모리 초과
 */

public class Main_1717 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		/*
			연관 관계를 나타내는 2차원 배열을 생성한다.
			0의 입력이 주어져서 합집합을 만들 경우, 연관 관계를 생성한다.
			1의 입력이 주어져서 확인할 경우, 연관 관계가 생성되어 있다면 YES, 아니라면 NO를 출력한다.
		 */

		boolean[][] relation = new boolean[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 합집합 : 연관 관계 생성
			if (op == 0) {
				for (int j = 0; j <= n; j++) {
					if (relation[a][j]) {
						relation[b][j] = true;
						relation[j][b] = true;
					}

					if (relation[b][j]) {
						relation[a][j] = true;
						relation[j][a] = true;
					}
				}

				relation[a][b] = true;
				relation[b][a] = true;
			}
			// 확인 : 연관 관계 확인
			else {
				sb.append(relation[a][b] ? "YES" : "NO").append("\n");
			}
		}

		System.out.print(sb);
	}
}
