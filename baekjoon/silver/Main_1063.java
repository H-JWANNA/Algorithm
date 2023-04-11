package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		/* 입력 값
		 * king : 왕의 위치
		 * rock : 돌의 위치
		 * n : 움직이는 횟수
		 */
		st = new StringTokenizer(br.readLine());
		String king = st.nextToken();
		String rock = st.nextToken();
		int n = Integer.parseInt(st.nextToken());

		Positions positions = new Positions(getPosition(king), getPosition(rock));

		for (int i = 0; i < n; i++) {
			switch (br.readLine()) {
				case "R":
					positions = movePosition(positions, 1, 0);
					break;
				case "L":
					positions = movePosition(positions, -1, 0);
					break;
				case "B":
					positions = movePosition(positions, 0, -1);
					break;
				case "T":
					positions = movePosition(positions, 0, 1);
					break;
				case "RT":
					positions = movePosition(positions, 1, 1);
					break;
				case "LT":
					positions = movePosition(positions, -1, 1);
					break;
				case "RB":
					positions = movePosition(positions, 1, -1);
					break;
				case "LB":
					positions = movePosition(positions, -1, -1);
					break;
			}
		}

		System.out.println(strPosition(positions.getKingPosition()));
		System.out.println(strPosition(positions.getRockPosition()));
	}

	private static int[] getPosition(String arg) {
		int[] position = new int[2];

		// 'A' : 17, '1' : 1
		position[0] = (arg.charAt(0) - '0') - 16;
		position[1] = arg.charAt(1) - '0';

		return position;
	}

	private static String strPosition(int[] position) {

		return String.valueOf((char)(position[0] + 16 + '0')) + position[1];
	}

	private static boolean isOnBoard(int[] position, int x, int y) {
		int xPosition = position[0] + x;
		int yPosition = position[1] + y;

		return xPosition > 0 && xPosition < 9 && yPosition > 0 && yPosition < 9;
	}

	private static boolean isThereRock(Positions positions, int x, int y) {
		int[] kingPosition = positions.getKingPosition();
		int[] rockPosition = positions.getRockPosition();

		return kingPosition[0] + x == rockPosition[0] && kingPosition[1] + y == rockPosition[1];
	}

	private static Positions movePosition(Positions positions, int x, int y) {
		int[] kingPosition = positions.getKingPosition();
		int[] rockPosition = positions.getRockPosition();

		// 왕이 움직인 자리에 돌이 있다면 돌도 움직이기
		if (isThereRock(positions, x, y)) {
			// 돌이 보드 밖으로 나갔다면 둘 다 움직이지 않는다.
			if (!isOnBoard(rockPosition, x, y)) {
				return positions;
			}
			// 나가지 않았다면 둘 다 움직인다.
			else {
				kingPosition[0] += x;
				kingPosition[1] += y;
				rockPosition[0] += x;
				rockPosition[1] += y;
			}
		}

		// 아니라면 왕만 움직이기
		else {
			// 왕이 보드 밖으로 나갔다면 움직이지 않는다.
			if (!isOnBoard(kingPosition, x, y)) {
				return positions;
			}
			// 나가지 않았다면 움직인다.
			else {
				kingPosition[0] += x;
				kingPosition[1] += y;
			}
		}

		return new Positions(kingPosition, rockPosition);
	}
}

class Positions {
	private int[] kingPosition;
	private int[] rockPosition;

	public Positions(int[] kingPosition, int[] rockPosition) {
		this.kingPosition = kingPosition;
		this.rockPosition = rockPosition;
	}

	public int[] getKingPosition() {
		return kingPosition;
	}

	public int[] getRockPosition() {
		return rockPosition;
	}
}
