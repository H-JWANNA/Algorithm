package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}

		// Arrays.sort()는 Quick 정렬을 사용하기 때문에 최악의 경우 O(n^2)의 시간 복잡도를 가짐
		// Collections.sort()는 Tim 정렬(Insertion + Merge 정렬)을 사용하기 때문에 O(NlogN)의 시간 복잡도를 가짐
		// Stream의 sorted()는 Arrays.sort() 메서드에 정렬 작업을 위임한다.
		Collections.sort(arr);

		arr.forEach(i -> sb.append(i).append("\n"));

		System.out.println(sb);
	}
}
