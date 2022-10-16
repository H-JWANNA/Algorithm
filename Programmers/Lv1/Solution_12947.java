package Lv1;

public class Solution_12947 {
    public boolean solution(int x) {
        int n = x;
        int num = 0;

        while(n > 0) {
            num += n % 10;
            n /= 10;
        }

        return x % num == 0;
    }
}
