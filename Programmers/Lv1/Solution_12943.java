package Lv1;

public class Solution_12943 {
    public int solution(int num) {
        int answer = 0;
        long x = num;

        while(x != 1 && answer < 500) {
            if (x % 2 == 0) x /= 2;
            else {
                x *= 3;
                x++;
            }
            answer++;
        }

        return answer >= 500 ? -1 : answer;
    }
}
