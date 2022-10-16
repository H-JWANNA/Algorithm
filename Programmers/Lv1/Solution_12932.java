package Lv1;

public class Solution_12932 {
    public int[] solution(long n) {
        String s = Long.toString(n);
        int len = s.length();
        int[] answer = new int[len];

        for(int i = 1; i <= len; i++) {
            answer[len - i] = s.charAt(i - 1) - '0';
        }

        return answer;
    }
}
