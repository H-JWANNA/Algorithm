public class Daily_41 {
  public static void main(String[] args) {
    int[] arr1 = {3, 6, 7, 8, 9, 21, 31, 32};
    int[] arr2 = {1, 3, 6, 7, 8, 9, 21, 31, 32};

    Daily_41 daily41 = new Daily_41();

    for (int i : arr2) {
      System.out.println(daily41.binarySearch(arr1, i));
      System.out.println(daily41.binarySearch(arr2, i));
    }
  }

  public int binarySearch(int[] arr, int target) {
    // 이진 탐색의 기준이 되는 시작과 끝 index를 지정한다.
    int left = 0;
    int right = arr.length - 1;

    // left가 right보다 커진다면 종료해야한다.
    while (left <= right) {

      // mid는 중간 index에 해당하는 값이다.
      int mid = (left + right) / 2;

      // 만약 해당 mid 값이 target이라면 해당 index를 리턴한다.
      if (arr[mid] == target) return mid;

      // target이 mid의 값보다 작다면 좌측으로 검색 범위를 줄인다
      if (arr[mid] > target) right = mid - 1;

      // target이 mid의 값보다 크다면 우측으로 검색 범위를 줄인다
      if (arr[mid] < target) left = mid + 1;
    }

    // 끝까지 못 찾으면 없는 것으로 간주
    return -1;
  }
}
