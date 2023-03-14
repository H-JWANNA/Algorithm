package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		// 1보다 크거나 같고, 200보다 작은 이름을 보관하기 위한 배열
		StringBuilder[] members = new StringBuilder[201];

		// NPE 방지 (append 시에 NPE 발생)
		for (int i = 0; i < members.length; i++) {
			members[i] = new StringBuilder();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			// 나이에 해당하는 index에 출력 내용을 입력한다.
			members[age].append(age).append(" ").append(name).append("\n");
		}

		for (StringBuilder member : members) {
			System.out.print(member);
		}

		/*
		 * Map 사용 시 key 값으로 중복된 이름이 저장되지 않아 틀린 경우가 발생한다.

		// 회원을 저장하기 위한 Map
		Map<String, Integer> members = new LinkedHashMap<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			members.put(name, age);
		}

		// 나이(Value)를 기준으로 정렬
		List<String> nameSet = new LinkedList<>(members.keySet());
		nameSet.sort((o1, o2) -> members.get(o1).compareTo(members.get(o2)));

		for (String name : nameSet) {
			System.out.println(members.get(name) + " " + name);
		}
		*/
	}
}
