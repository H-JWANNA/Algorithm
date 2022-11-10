import java.util.Arrays;

public class Daily_35 {
    static int[] result;

    public static void main(String[] args) {
        Daily_35 daily35 = new Daily_35();
        System.out.println(Arrays.toString(daily35.quickSort(new int[] {5, 4, 3, 2, 1})));
    }

    public int[] quickSort(int[] arr) {
        result = Arrays.copyOf(arr, arr.length);
        leftPivotSort(result, 0, result.length - 1);
        return result;
    }

    // 왼쪽 피벗 선택 퀵정렬
    private void leftPivotSort (int[] arr, int low, int high) {
        // low 가 high 보다 크거나 같아지면 정렬할 원소가 1개 이하이므로 종료
        if (low >= high) return;

        int pivot = partition(arr, low, high);

        // 좌측 분할 정렬
        leftPivotSort(arr, low, pivot - 1);
        // 우측 분할 정렬
        leftPivotSort(arr, pivot + 1, high);
    }

    // 피벗을 기준으로 파티션을 나누기 위한 약한 정렬 메서드
    private int partition(int[] arr, int left, int right) {
        int low = left;
        int high = right;
        int pivot = arr[left];

        // low 가 high 보다 작을 때 까지만 반복
        while(low < high) {

            // high 가 피벗보다 작은 원소를 찾을 때 까지 high 를 감소시킨다.
            while(arr[high] > pivot && low < high) high--;

            // low 가 피벗보다 큰 원소를 찾을 때 까지 low 를 증가시킨다
            while(arr[low] <= pivot && low < high) low++;

            // 두 요소를 모두 찾으면 교환한다.
            swap(arr, low, high);
        }

        // 마지막으로 맨 처음 피벗으로 설정했던 원소와 low 에 해당하는 원소를 교환한다.
        swap(arr, left, low);

        // 피벗으로 설정되었던 요소는 low 에 위치하므로 해당 값을 반환한다.
        return low;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
