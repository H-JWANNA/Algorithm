package Lv2;

import java.util.*;

public class Solution_12939 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ");

        int index = 0;
        int min = 0;
        int max = 0;

        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (index == 0) {
                min = num;
                max = num;
            }

            min = Math.min(min, num);
            max = Math.max(max, num);

            index++;
        }

        sb.append(min);
        sb.append(" ");
        sb.append(max);

        return sb.toString();
    }
}
