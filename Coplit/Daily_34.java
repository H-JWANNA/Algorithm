import java.util.Arrays;

public class Daily_34 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] NxM_matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        Daily_34 daily34 = new Daily_34();
        System.out.println(Arrays.deepToString(daily34.rotateMatrix(matrix, 2)));
        System.out.println(Arrays.deepToString(daily34.rotateMatrix(NxM_matrix, 3)));
    }

    public int[][] rotateMatrix (int[][] matrix, int K) {
        // 빈 배열을 입력받은 경우 빈 배열 리턴
        if(matrix == null || matrix.length == 0) return matrix;

        // 변수 생성
        int N = matrix.length - 1;
        int M = matrix[0].length - 1;
        int rotation = K % 4;

        // 결과를 리턴할 배열 생성
        int[][] result;
        if (rotation % 2 == 0) result = new int[N + 1][M + 1];
        else result = new int[M + 1][N + 1];

        // 배열을 시계 방향으로 90도 회전시키는 방법은
        // [i][j] => [j][N - i]
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                switch (rotation) {
                    case 0:
                        result[i][j] = matrix[i][j];
                        break;
                    case 1:
                        result[j][N - i] = matrix[i][j];
                        break;
                    case 2:
                        result[N - i][M - j] = matrix[i][j];
                        break;
                    case 3:
                        result[M - j][i] = matrix[i][j];
                        break;
                }
            }
        }

        return result;
    }
}
