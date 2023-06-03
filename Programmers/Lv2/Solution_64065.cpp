#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<string> split(string input, string delim) {
    vector<string> answer;

    int prev = 0;
    int cur;
    cur = input.find(delim);

    while(cur != -1) {
        string sub = input.substr(prev, cur - prev);

        answer.push_back(sub);

        prev = cur + delim.length();
        cur = input.find(delim, prev);
    }

    answer.push_back(input.substr(prev, cur - prev));

    return answer;
}

vector<int> splitToInt(string input, string delim) {
    vector<int> answer;

    int prev = 0;
    int cur;
    cur = input.find(delim);

    while(cur != -1) {
        string sub = input.substr(prev, cur - prev);

        answer.push_back(stoi(sub));

        prev = cur + delim.length();
        cur = input.find(delim, prev);
    }

    answer.push_back(stoi(input.substr(prev, cur - prev)));

    return answer;
}

bool compLong(string s1, string s2) {
    return s1.length() < s2.length();
}

int sum(vector<int> v) {
    int x = 0;

    for(int i : v) {
        x += i;
    }

    return x;
}

vector<int> solution(string s) {
    vector<int> answer;

    string str = s.substr(2, s.size() - 4);
    vector<string> sstr = split(str, "},{");
    sort(sstr.begin(), sstr.end(), compLong);

    vector<vector<int>> numbers;

    for(string sss : sstr) {
        numbers.push_back(splitToInt(sss, ","));
    }

    int prev_sum = 0;
    int now_sum;

    for(int i = 0; i < numbers.size(); i++) {
        now_sum = sum(numbers[i]);
        // cout << "prev_sum은 " << prev_sum << ", now_sum은 " << now_sum << endl;
        answer.push_back(answer.empty() ? now_sum : now_sum - prev_sum);
        // cout << "저장 : " << answer.back() << endl;
        prev_sum = now_sum;
    }

    return answer;
}
