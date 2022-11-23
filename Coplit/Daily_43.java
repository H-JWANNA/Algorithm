public class Daily_43 {
  public static void main(String[] args) {

    Character[][] input1 = new Character[][] {
        {'A', 'B', 'C'},
        {'L', 'M', 'D'},
        {'K', 'N', 'E'},
        {'J', 'O', 'F'},
        {'I', 'H', 'G'}
    };

    Character[][] input2 = new Character[][] {
        {'1', '2', '3'},
        {'8', '9', '4'},
        {'7', '6', '5'}
    };

    Character[][] input3 = new Character[][] {
        {'T', 'y', 'r', 'i'},
        {'i', 's', 't', 'o'},
        {'n', 'r', 'e', 'n'},
        {'n', 'a', 'L', ' '}
    };

    Character[][] input4 = new Character[][] {
        {'H', 'e', 'l', 'l', 'o', ',', ' ', 'w'},
        {'S', 'P', 'R', 'I', 'N', 'G', ' ', 'o'},
        {' ', 'y', '1', '2', '3', '4', 's', 'r'},
        {',', 't', 'i', 'r', 'u', 'c', 'e', 'l'},
        {'o', 'l', 'l', 'e', 'H', ' ', '.', 'd'}
    };

    System.out.println(spiralTraversal(input1));
    System.out.println(spiralTraversal(input2));
    System.out.println(spiralTraversal(input3));
    System.out.println(spiralTraversal(input4));
  }

  static String spiralTraversal(Character[][] matrix) {
    // 출력 값을 저장할 StringBuilder
    StringBuilder sb = new StringBuilder();

    // X축 : 가장 좌측과 우측의 인덱스에 해당하는 변수 생성
    int left = 0;
    int right = matrix[0].length - 1;

    // Y축 : 가장 상단과 하단의 인덱스에 해당하는 변수 생성
    int top = 0;
    int bottom = matrix.length - 1;

    // 중복 값을 허용하지 않기 위한 배열
    boolean[][] visited = new boolean[bottom + 1][right + 1];

    // 두 인덱스가 서로 만나는 지점에서 끝나야 한다.
    while(left <= right && top <= bottom) {

      // 상단 탐색
      for (int i = left; i <= right; i++)  {
        if (!visited[top][i]) {
          visited[top][i] = true;
          sb.append(matrix[top][i]);
        }
      }

      // 우측 탐색
      for (int i = top; i <= bottom; i++) {
        if (!visited[i][right]) {
          visited[i][right] = true;
          sb.append(matrix[i][right]);
        }
      }

      // 하단 탐색
      for (int i = right; i >= left; i--) {
        if (!visited[bottom][i]) {
          visited[bottom][i] = true;
          sb.append(matrix[bottom][i]);
        }
      }

      // 좌측 탐색
      for (int i = bottom; i >= top; i--) {
        if (!visited[i][left]) {
          visited[i][left] = true;
          sb.append(matrix[i][left]);
        }
      }

      // 각 인덱스를 한 칸씩 안 쪽으로 이동
      left++;
      right--;
      top++;
      bottom--;
    }

    return sb.toString();
  }

  // visited 배열을 쓰지 않고 문자열의 최대 길이를 통해서 판별해도 괜찮을 듯
}
