package Lv1;

public class Solution_12916 {
    boolean solution(String s) {
        s = s.toLowerCase();
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == 'p') result += 1;
            if(c == 'y') result -= 1;
        }

        return result == 0;
    }
}
