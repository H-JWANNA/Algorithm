package Lv1;

public class Solution_12931 {
    public static int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n);

        for(int i = 0; i < s.length(); i++) {
            answer += s.charAt(i) - '0';
        }

        return answer;
    }
}
