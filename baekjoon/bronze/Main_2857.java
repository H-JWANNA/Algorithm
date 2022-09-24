package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length() - 2; j++) {
                if('F' == str.charAt(j) && 'B' == str.charAt(j+1) && 'I' == str.charAt(j+2)) {
                    arrayList.add(i);
                    break;
                }
            }
        }

        if(arrayList.size() == 0) System.out.println("HE GOT AWAY!");
        else {
            System.out.println(arrayList.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        }
    }
}
