package Lv1;

public class Solution_12954 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i = 1; i <= n; i++) {
            answer[i - 1] = x;
            answer[i - 1] *= i;
        }

        return answer;
    }
}
