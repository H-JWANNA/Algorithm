package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1927 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(input.readLine());

    // 우선순위 큐 생성
    PriorityQueue<Integer> q = new PriorityQueue<>();

    // N번 반복한다.
    for (int i = 0; i < n; i++) {
      int m = Integer.parseInt(input.readLine());

      switch (m) {
        // 해당 숫자가 0일 때, q가 비어있다면 0을 출력, 아니라면 최소 값을 출력
        case 0:
          System.out.println(q.isEmpty() ? 0 : q.poll());
          break;

        // 해당 숫자가 0이 아닐 때, 해당 값을 q에 추가
        default:
          q.add(m);
      }
    }
  }
}
