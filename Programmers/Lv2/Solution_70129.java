package Lv2;

public class Solution_70129 {
    public int[] solution(String s) {
        int zero = 0;
        int count = 0;

        while(!s.equals("1")) {
            int len = 0;

            for(int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero++;
                }
                else len += 1;
            }

            s = Integer.toBinaryString(len);
            count++;
        }

        return new int[] {count, zero};
    }
}
