package silver;

import java.io.*;
import java.util.*;

public class Main_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            hashSet.add(input.readLine());
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = input.readLine();
            if(hashSet.contains(name)) result.add(name);
        }

        System.out.println(result.size());

        Collections.sort(result);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
