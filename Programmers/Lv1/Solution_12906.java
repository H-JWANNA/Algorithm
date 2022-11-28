package Lv1;

import java.util.ArrayList;

public class Solution_12906 {
  public Integer[] solution(int []arr) {
    ArrayList<Integer> list = new ArrayList<>();
    int repeat = Integer.MIN_VALUE;

    for(int i : arr) {
      if(repeat != i) {
        repeat = i;
        list.add(i);
      }
    }

    return list.toArray(Integer[]::new);
  }
}
