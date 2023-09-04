package Lv1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Solution_176963 {
	public int[] solution(String[] name, int[] yearning, String[][] photo) {
		Map<String, Integer> scores = new HashMap<>();

		for(int i = 0; i < name.length; i++) {
			scores.put(name[i], yearning[i]);
		}

		int[] answer = new int[photo.length];

		for(int i = 0; i < photo.length; i++) {
			int score = 0;

			for(int j = 0; j < photo[i].length; j++) {
				String curName = photo[i][j];
				Integer curScore = Optional.ofNullable(scores.get(curName)).orElse(0);
				score += curScore;
			}

			answer[i] = score;
		}

		return answer;
	}
}
