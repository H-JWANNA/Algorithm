package Lv1;

public class Solution_12903 {
  public String solution(String s) {
    int len = s.length();
    StringBuilder sb = new StringBuilder();

    // 짝수일 경우
    if (len % 2 == 0) {
      sb.append(s.charAt(len / 2 - 1));
      sb.append(s.charAt(len / 2));
    }
    // 홀수일 경우
    else
      sb.append(s.charAt(len / 2));

    return sb.toString();
  }
}
