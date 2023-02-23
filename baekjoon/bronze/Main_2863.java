package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2863 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int answer = 0;
		double max = 0;
		double[][] chart = new double[2][2];

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			chart[i][0] = Integer.parseInt(st.nextToken());
			chart[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 4; i++) {
			double value = (chart[0][0] / chart[1][0]) + (chart[0][1]/chart[1][1]);

			if (value > max) {
				max = value;
				answer = i;
			}

			double temp = chart[0][1];
			chart[0][1] = chart[0][0];
			chart[0][0] = chart[1][0];
			chart[1][0] = chart[1][1];
			chart[1][1] = temp;
		}

		System.out.println(answer);
	}
}
