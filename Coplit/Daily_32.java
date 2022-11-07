import java.util.Arrays;

public class Daily_32 {
    public int orderOfPresentation(int N, int[] K) {
        int result = 0;

        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < K.length; i++) {
            int num = K[i];

            visited[num] = true;

            boolean[] copyVisit = Arrays.copyOfRange(visited, 1, num);

            int validCount = 0;
            for (boolean is : copyVisit)
                if (!is) validCount++;

            result += (validCount * factorial(N - i - 1));
        }

        return result;
    }

    public int factorial (int n) {
        int num = 1;

        for (int i = n; i > 1; i--)
            num *= i;
        return num;
    }
}
