#include <vector>

using namespace std;

int solution(int n) {
    vector<int> dp;
    dp.push_back(0);
    dp.push_back(1);

    for(int i = 2; i <= n; i++) {
        int cur = (dp[i - 1] + dp[i - 2]) % 1234567;
        dp.push_back(cur);
    }

    return dp[n];
}
