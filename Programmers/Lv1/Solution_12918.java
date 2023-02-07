package Lv1;

public class Solution_12918 {
	public boolean solution(String s) {
		int[] arr = s.chars().toArray();

		if(arr.length != 4 && arr.length != 6) {
			return false;
		}

		for(int i : arr) {
			if (i < 48 || i > 57) {
				return false;
			}
		}

		return true;
	}
}
