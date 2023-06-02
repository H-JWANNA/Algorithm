#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int count = citations.size();

    sort(citations.begin(), citations.end());

    for(int i = 0; i < citations.size(); i++) {
        if (count <= citations[i]) {
            return count;
        }

        count--;
    }

    return count;
}
