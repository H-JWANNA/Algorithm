#include <vector>

using namespace std;

int solution(vector<int> absolutes, vector<bool> signs) {
    int answer = 0;

    for(int i = 0; i < absolutes.size(); i++) {
        int cur = signs[i] ? absolutes[i] : -absolutes[i];

        answer += cur;
    }

    return answer;
}
