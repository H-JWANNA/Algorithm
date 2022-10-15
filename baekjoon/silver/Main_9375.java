// 메모리 : 11824KB
// 시간 : 84ms

package silver;

import java.io.*;
import java.util.*;

public class Main_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(input.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(input.readLine());

            HashMap<String, Integer> hashMap = new HashMap<>();
            int result = 1;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(input.readLine());

                // 의상의 이름은 필요 없으니 패스
                st.nextToken();
                // 의상의 종류만 저장
                String type = st.nextToken();


                // 이미 있는 종류이면 1개 증가, 아니라면 1개 추가
                if (hashMap.containsKey(type)) {
                    hashMap.put(type, hashMap.get(type) + 1);
                }
                else {
                    hashMap.put(type, 1);
                }
            }

            // 각 value 에 1을 더해 결과에 저장 (안 입었을 경우를 포함해 nC1)
            for (Integer value : hashMap.values()) {
                result *= value + 1;
            }

            // 모든 종류를 안 입은 경우 1을 제외하고 결과값 출력
            output.write(Integer.toString(result - 1));
            output.newLine();
        }

        output.flush();
        output.close();
    }
}
