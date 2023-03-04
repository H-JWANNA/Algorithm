package Lv1;

public class Solution_81301 {
	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
		System.out.println(solution("23four5six7"));
		System.out.println(solution("2three45sixseven"));
		System.out.println(solution("123"));
	}

	public static int solution(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// 숫자일 경우 그냥 추가
			if (c - '0' >= 0 && c - '0' <= 9) {
				sb.append(c - '0');
			}

			// 문자일 경우 해당 글자를 찾아서 추가
			else {
				switch (c) {
					case 'z':
						sb.append(0);
						i += 3;
						break;
					case 'o':
						sb.append(1);
						i += 2;
						break;
					case 't':
						if (s.charAt(i + 1) == 'w') {
							sb.append(2);
							i += 2;
						} else {
							sb.append(3);
							i += 4;
						}
						break;
					case 'f':
						sb.append(s.charAt(i + 1) == 'o' ? 4 : 5);
						i += 3;
						break;
					case 's':
						if (s.charAt(i + 1) == 'i') {
							sb.append(6);
							i += 2;
						} else {
							sb.append(7);
							i += 4;
						}
						break;
					case 'e':
						sb.append(8);
						i += 4;
						break;
					case 'n':
						sb.append(9);
						i += 3;
						break;
				}
			}
		}

		return Integer.parseInt(sb.toString());
	}
}
