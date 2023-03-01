package Lv1;

public class Solution_12930 {
	public static void main(String[] args) {
		String s = "try hello world";
		String s2 = "try hello    world  ";

		System.out.println(solution(s));
		System.out.println(solution(s2));
	}

	public static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		int index = 0;

		for (int i = 0; i < s.length(); i++) {
			String str = Character.toString(s.charAt(i));

			// 공백 추가
			if (str.isBlank()) {
				index = 0;
				sb.append(" ");
				continue;
			}

			// 대소문자 추가
			sb.append(index % 2 == 0 ? str.toUpperCase() : str.toLowerCase());
			index++;
		}

		return sb.toString();
	}

	/*
	public static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		String[] arr = s.split(" ");

		System.out.println(Arrays.toString(arr));

		for (String str : arr) {
			// 공백 문자 추가
			if (str.isBlank()) {
				sb.append(" ");
				continue;
			}

			for (int i = 0; i < str.length(); i++) {
				if (i % 2 == 0) {
					sb.append(Character.toString(str.charAt(i)).toUpperCase());
				} else {
					sb.append(Character.toString(str.charAt(i)).toLowerCase());
				}
			}

			sb.append(" ");
		}

		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}
	*/
}
