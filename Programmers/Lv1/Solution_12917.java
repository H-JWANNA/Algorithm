package Lv1;

import java.util.*;

public class Solution_12917 {
	public String solution(String s) {

		String[] arr = s.split("");

		Arrays.sort(arr, Collections.reverseOrder());

		return String.join("", arr);
	}
}
