package Lv1;

import java.util.Arrays;

public class Solution_12935 {
  public int[] solution(int[] arr) {

    // 기존 배열에서 1칸 적은 배열 생성
    int len = arr.length - 1;
    // 만약 빈배열일 경우 [-1] 리턴
    if(len == 0) return new int[] {-1};
    int[] answer = new int[len];

    // 최소값 구하기
    int min = Arrays.stream(arr).min().getAsInt();

    // 생성한 배열에 최소값을 제외하고 붙여넣기
    int arrIndex = 0;
    int ansIndex = 0;

    while(len > ansIndex) {
      // 만약 최소값일 경우 arrIndex 증가하고 건너뛰기
      if (arr[arrIndex] == min) {
        arrIndex++;
        continue;
      }
      // 값 붙여넣기
      answer[ansIndex] = arr[arrIndex];

      // 인덱스 값 증가
      arrIndex++;
      ansIndex++;
    }

    return answer;
  }
}
