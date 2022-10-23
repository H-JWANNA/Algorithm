package Lv2;

import java.util.*;

public class Solution_12981 {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[]{0, 0};

        for (int i = 0; i < words.length; i++) {
            if (set.contains(words[i])) {
                answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
                answer[1] = (i / n) + 1;
                break;
            }

            set.add(words[i]);

            if (i > 0) {
                char last = words[i - 1].charAt(words[i - 1].length() - 1);
                char first = words[i].charAt(0);

                if(first != last) {
                    answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
                    answer[1] = (i / n) + 1;
                    break;
                }
            }
        }
        return answer;
    }
}
