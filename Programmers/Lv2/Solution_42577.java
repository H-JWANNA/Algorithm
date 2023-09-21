package Lv2;

import java.util.*;

public class Solution_42577 {
	public boolean solution(String[] phone_book) {
		Set<String> book = new HashSet<>();

		// 길이 짧은 순으로 정렬해야 ["123", "12"] 같은 예외에 안 걸림
		Arrays.sort(phone_book);

		// 배열 돌면서 부분 문자열이 저장된 번호인지 확인
		for(String s : phone_book) {
			for(int i = 1; i <= s.length(); i++) {
				String str = s.substring(0, i);

				if (book.contains(str)) {
					return false;
				}
			}

			book.add(s);
		}

		return true;
	}
}
