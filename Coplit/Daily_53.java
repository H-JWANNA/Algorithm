import java.util.Arrays;

public class Daily_53 {
  // Best Solution => Segment Tree

  public static int[] rangeMinimum(int[] arr, int[][] ranges) {
    // 정답을 저장할 배열
    int[] answer = new int[ranges.length];

    // ranges length 만큼 순회 -> O(N)
    for (int i = 0; i < ranges.length; i++) {

      // 기존 Array 특정 부분을 가져온다.
      int[] subArr = Arrays.copyOfRange(arr, ranges[i][0], ranges[i][1] + 1);

      // Sort -> O(NlogN)
      Arrays.sort(subArr);

      answer[i] = subArr[0];
    }

    return answer;
  }
}
