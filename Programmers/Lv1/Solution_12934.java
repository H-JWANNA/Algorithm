package Lv1;

public class Solution_12934 {
    public long solution(long n) {
         int x = (int) Math.sqrt(n);

        return (long) Math.pow(x, 2) == n
                ? (long) Math.pow(x + 1, 2)
                : -1;
    }
}
