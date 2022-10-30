package Lv1;

public class Solution_12940 {
    public int[] solution (int n, int m) {
        // n은 항상 m보다 커야한다
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
        }

        int gcdNum = gcd(n, m);

        return new int[] {gcdNum, lcm(n, m, gcdNum)};
    }

    public int gcd (int n, int m) {
        // 유클리드 호제법
        if(m == 0) return n;

        return gcd(m, n % m);
    }

    public int lcm (int n, int m, int gcd) {
        return (n * m) / gcd;
    }
}
