package Lv1;

class Solution_12928 {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                answer += i;

                if(Math.pow(i, 2) == n) continue;

                answer += n/i;
            }
        }

        return answer;
    }
}