import java.util.*;

public class Daily_37 {
  public static void main(String[] args) {
    int[] arr1 = {5, 4, 3, 2, 1};
    int[] arr2 = {13, 21, 423, 1000, 121, 1, 24};
    int[] arr3 = {221, 12, 229, 84, 120, 8, 2, 900000};

    Daily_37 daily37 = new Daily_37();

    System.out.println(Arrays.toString(daily37.radixSort(arr1)));
    System.out.println(Arrays.toString(daily37.radixSort(arr2)));
    System.out.println(Arrays.toString(daily37.radixSort(arr3)));
  }

  public int[] radixSort (int[] arr) {
    // 배열에서 최대 값을 구한다.
    int maxNum = getMax(arr);

    // 자릿수 0 ~ 9까지 담을 Queue 생성
    List<Queue<Integer>> list = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      Queue<Integer> q = new LinkedList<>();
      list.add(q);
    }

    // 최대 값의 자릿수까지 반복한다.
    for (int exp = 1; exp <= maxNum; exp *= 10) {
      System.out.println("=".repeat(30));
      System.out.println("exp = " + exp);

      for (int num : arr) {
        // 배열을 탐색하면서 자릿수에 해당하는 값을 구함 ( 0 ~ 9 )
        int index = (num / exp) % 10;

        System.out.println("index = " + index + ", num = " + num);

        // 해당 자릿수에 해당하는 Queue 에 값을 넣는다.
        list.get(index).add(num);
      }

      int arrIndex = 0;
      // 0 ~ 9까지 담긴 Queue 를 반복하면서
      for (int i = 0; i < 10; i++) {
        Queue<Integer> q = list.get(i);
        int qSize = q.size(); // qSize 를 선언하지 않고 아래 반복문에 q.Size()를 대입하면 제대로 size 를 인식하지 못함
        System.out.println(i + "번째 q : " + q);

        // Queue 의 값을 arr 에 정렬한 후 다음 자릿수에 대해 반복한다.
        for (int j = 0; j < qSize; j++) {
          arr[arrIndex] = q.poll();
          System.out.println("arrIndex = " + arrIndex + ", arr[index] = " + arr[arrIndex]);
          arrIndex++;
        }
      }

      System.out.println(exp + "의 자리 수 정렬");
      System.out.println(Arrays.toString(arr));
    }

    return arr;
  }

  public int getMax (int[] arr) {
    int maxNum = 0;

    for (int i : arr) if (i > maxNum) maxNum = i;

    return maxNum;
  }
}
