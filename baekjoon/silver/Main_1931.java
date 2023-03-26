package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(input.readLine());
    int[][] meeting = new int[n][];
    int result = 0;

    // 값 입력
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine(), " ");

      int[] time = new int[2];
      time[0] = Integer.parseInt(st.nextToken());
      time[1] = Integer.parseInt(st.nextToken());

      meeting[i] = time;
    }

    // 2차원 배열 정렬
    Arrays.sort(meeting, Comparator.comparingInt(o -> o[0]));

    // meeting 배열 순회
//    for (int i = 0; i < meeting.length; i++) {
//      if (meeting[i][1] <= meeting[i + 1][0])
//    }

    System.out.println(Arrays.deepToString(meeting));
  }
}
