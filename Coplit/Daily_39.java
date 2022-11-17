import java.util.*;

public class Daily_39 {
  public int[] heapSort(int[] arr) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int len = arr.length;

    // 배열을 힙으로 만든다
    for (int i : arr) {
      heap.add(i);
    }

    // 힙에서 우선 순위가 높은 원소를 하나씩 뽑는다.
    for (int i = 0; i < len; i++) {
      arr[i] = heap.remove();
    }

    return arr;
  }
}
