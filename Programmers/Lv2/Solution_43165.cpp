#include <queue>
#include <vector>

using namespace std;

int count = 0;

struct Num {
    int sum, index;
};

int solution(vector<int> numbers, int target) {
    queue<Num> q;
    q.push({0, 0});

    while(!q.empty()) {
        int cur_sum = q.front().sum;
        int cur_idx = q.front().index;
        q.pop();

        if (cur_idx == numbers.size()) {
            if (cur_sum == target) {
                count++;
            }

            continue;
        }

        q.push({cur_sum + numbers[cur_idx], cur_idx + 1});
        q.push({cur_sum - numbers[cur_idx], cur_idx + 1});
    }

    return count;
}
