package silver;

import java.io.*;
import java.util.*;

public class Main_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(input.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 해시맵을 이용하여 사이트 주소와 비밀번호 담기
        HashMap<String, String> sitePW = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            String site = st.nextToken();
            String pw = st.nextToken();
            sitePW.put(site, pw);
        }

        // 해시맵의 키값을 통해 비밀번호 찾기
        for (int i = 0; i < m; i++) {
            bw.write( sitePW.get( input.readLine() ) );
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
