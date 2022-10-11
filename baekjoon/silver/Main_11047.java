package silver;

import java.io.*;
import java.util.*;

public class Main_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());

        // 동전의 가치를 담을 배열
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }

        // value 값 빼면서 동전 갯수 확인하기
        int count = 0;
        int index = n - 1;
        while(value != 0) {
            if(value >= arr[index]) {
                value -= arr[index];
                count++;
            }
            else index -= 1;
        }
        System.out.println(count);
    }
}
