public class Daily_44 {
  public int LSCS(int[] arr) {
    // 배열의 합을 저장할 변수, 최대값을 저장할 변수
    int sumArr = 0;
    int max = Integer.MIN_VALUE;

    for (int i : arr) {
      // 배열의 값을 하나씩 더한다.
      sumArr += i;

      // 최대값과 비교하여, 최대값을 갱신한다.
      if (sumArr > max) max = sumArr;

      // 만약 합이 음수가 될 경우, 초기화 하고 다음 index부터 다시 배열의 합을 구한다.
      if (sumArr < 0) sumArr = 0;
    }
    return max;
  }
}
