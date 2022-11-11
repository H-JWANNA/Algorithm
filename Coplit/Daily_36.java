import java.util.Arrays;

public class Daily_36 {
    public static void main(String[] args) {
        int[] arr1 = {5, 4, 3, 2, 1};
        int[] arr2 = {13, 21, 423, 1000, 121, 1, -10, 24};
        int[] arr3 = {221, -110, -11, 12, 229, 84, 120, 8, 2};

        Daily_36 daily36 = new Daily_36();
        System.out.println(Arrays.toString(daily36.insertionSort(arr1)));
        System.out.println(Arrays.toString(daily36.insertionSort(arr2)));
        System.out.println(Arrays.toString(daily36.insertionSort(arr3)));
    }

    public int[] insertionSort(int[] arr) {

        // 마지막 원소까지 반복
        for (int i = 1; i < arr.length; i++) {
            // 비교할 수
            int targetNum = arr[i];

            // i - 1 번째 수와 비교한다
            int compareIndex = i - 1;

            // compareIndex 가 가장 앞에 올 때까지, targetNum 이 이전의 값보다 작거나 같으면 반복
            while (compareIndex >= 0 && arr[compareIndex] >= targetNum) {

                // 한 칸 씩 뒤로 미룬다.
                arr[compareIndex + 1] = arr[compareIndex];

                // 이전의 값과 다시 비교하기 위해 target 을 줄인다.
                compareIndex--;
            }
            // targetNum 은 마지막까지 비교했을때 더 이상 움직이지 않는 compareIndex 에 들어가야하지만
            // 마지막에 compareIndex-- 를 해주있으므로 +1을 해준 위치에 위치한다.
            arr[compareIndex + 1] = targetNum;
        }

        return arr;
    }
}
