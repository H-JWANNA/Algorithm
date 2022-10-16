package Lv1;

import java.util.*;

public class Solution_12933 {
    // 1번째 풀이
    public long solution(long n) {
        Integer[] arr = Long.toString(n)
                .chars()
                .map(c -> c - '0')
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);

        StringBuilder sb = new StringBuilder();

        for(int i : arr) {
            sb.append(i);
        }

        return Long.parseLong(sb.toString());
    }

    // 2번째 풀이

}
