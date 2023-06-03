#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int count = 0;

int solution(vector<vector<int>> board, vector<int> moves) {
    /*
        moves[i] - 1 값이 탐색할 column
        해당 board[depth][column] 값이 0일 경우 depth 값을 증가시키면서 0이 아닐 때까지 확인한다.

        stack에 쌓으며 이번에 들어온 값과 기존 스택 가장 위의 값이 같으면 삭제하고 count를 2 증가시킨다.
        그렇지 않으면 스택에 추가한다.
    */

    stack<int> bucket;

    int depth = board.size();

    for(int move : moves) {
        int col = move - 1;
        // cout << "===== now col : " << col << endl;

        for(int y = 0; y < depth; y++) {
            int doll = board[y][col];
            // cout << "doll : " << doll << endl;

            if (doll == 0) {
                continue;
            }

            board[y][col] = 0;

            if (!bucket.empty()) {
                // cout << ">> top " << bucket.top() << endl;

                if (bucket.top() == doll) {
                    // cout << "ooo Pop ooo" << endl;
                    bucket.pop();
                    count += 2;
                    break;
                }
            }

            bucket.push(doll);
            // cout << ">> push " << doll << endl;
            break;
        }
    }

    return count;
}
