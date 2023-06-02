#include <stack>
#include <string>
using namespace std;

int solution(string s) {
    stack<char> stack;

    for(int i = 0; i < s.length(); i++) {
        char cur = s[i];

        if (!stack.empty() && cur == stack.top()) {
            stack.pop();
        } else {
            stack.push(cur);
        }
    }

    return stack.empty() ? 1 : 0;
}
