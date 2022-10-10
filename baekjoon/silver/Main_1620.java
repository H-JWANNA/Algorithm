package silver;

import java.io.*;
import java.util.*;

public class Main_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(input.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> pokemonMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = input.readLine();
            String num = Integer.toString(i);
            pokemonMap.put(name, num);
            pokemonMap.put(num, name);
        }

        for (int i = 0; i < m; i++) {
            System.out.println(pokemonMap.get( input.readLine() ));
        }
    }
}
