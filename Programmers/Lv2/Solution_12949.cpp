#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    /*
        m * n 과 n * r 행렬을 곱하면 m * r 행렬이 된다.
        {
        [a00*b00 + a01*b10, a00*b01 + a01*b11],
        [a10*b00 + a11*b10, a10*b01 + a11*b11],
        [a20*b00 + a21*b10, a20*b01 + a21*b11]

        [a(mn)*b(nr) + a(mn)*b(nr) + ... , ...]
        }
    */

    vector<vector<int>> answer;

    int M = arr1.size();
    int N = arr2.size();
    int R = arr2[0].size();

    for(int m = 0; m < M; m++) {
        vector<int> v;

        for(int r = 0; r < R; r++) {
            int cur = 0;

            for (int n = 0; n < N; n++) {
                cur += arr1[m][n] * arr2[n][r];
            }

            v.push_back(cur);
        }

        answer.push_back(v);
    }

    return answer;
}
