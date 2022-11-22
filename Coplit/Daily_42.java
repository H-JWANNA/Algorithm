public class Daily_42 {

  // 시간 복잡도 : O(N)
  public int getItemFromTwoSortedArrays(int[] arr1, int[] arr2, int k) {
    // 초기 값
    int i = 0, j = 0, x = 0;
    int m = arr1.length, n = arr2.length;

    // 두 배열을 합친 배열
    int[] sorted = new int[m + n];

    // 두 배열 중 작은 값을 넣기
    while (i < m && j < n) {
      if (arr1[i] < arr2[j])
        sorted[x++] = arr1[i++];
      else
        sorted[x++] = arr2[j++];
    }

    // 둘 중의 한 배열이 먼저 끝났을 경우, 나머지 배열 값 넣기
    while (i < m) sorted[x++] = arr1[i++];

    while (j < n) sorted[x++] = arr2[j++];

    return sorted[k - 1];
  }

  // 시간 복잡도 : O(log(min(m,n)))
  public int kthElement(int[] arr1, int[] arr2, int k) {
    if (arr1.length > arr2.length)
      return kthElement(arr2, arr1, k);

    int m = arr1.length, n = arr2.length;

    int low = Math.max(0, k - m), high = Math.min(k, n);

    while (low <= high) {
      int cut1 = (low + high) >> 1;
      int cut2 = k - cut1;
      int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
      int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
      int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
      int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

      if (l1 <= r2 && l2 <= r1) {
        return Math.max(l1, l2);
      } else if (l1 > r2) {
        high = cut1 - 1;
      } else {
        low = cut1 + 1;
      }
    }
    return -1;
  }
}
