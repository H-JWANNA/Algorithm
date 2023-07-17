package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1107 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int channel = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		if (m > 0) {
			st = new StringTokenizer(br.readLine(), " ");
		}

		boolean[] broken = new boolean[10];

		while (m-- > 0) {
			int button = Integer.parseInt(st.nextToken());

			broken[button] = true;
		}

		int min = Math.abs(100 - channel);

		// 0부터 999999 채널까지 갈 수 있는지 확인하고, 갈 수 있다면 몇 번 클릭에 갈 수 있는지 구하기
		for (int i = 0; i <= 999999; i++) {
			boolean isBroken = false;

			int[] buttons = Arrays.stream(Integer.toString(i).split(""))
				.map(Integer::parseInt)
				.mapToInt(button -> button)
				.toArray();

			for (int button : buttons) {
				// 고장난 버튼이라면 갈 수 없다.
				if (broken[button]) {
					isBroken = true;
					break;
				}
			}

			if (isBroken) {
				continue;
			}

			//  count = ( +,-를 눌러야 하는 횟수 ) + ( 리모컨 숫자를 누른 횟수 )
			int count = Math.abs(channel - i) + buttons.length;
			min = Math.min(min, count);
		}

		System.out.println(min);
	}
}
