#include <cmath>

using namespace std;

int solution(int n, int a, int b) {
    /*
        2의 n제곱 명의 참가자가 있을 때,
        처음 절반으로 나눴을 때, 서로가 양쪽에 있다면 n라운드 후에 만난다.
        같은 쪽에 있다면, 다시 절반으로 나눠서 양쪽에 있다면 n-1라운드 후에 만난다.
    */

    int round = log2(n);
    int start = 1;
    int end = n;
    int center = (start + end) / 2;

    for(int i = 0; i < round; i++) {
        if (a >= start && b >= start && a <= center && b <= center) {
            end = center;
            center = (start + end) / 2;
        } else if (a > center && b > center && a <= end && b <= end) {
            start = center + 1;
            center = (start + end) / 2;
        } else {
            return round - i;
        }
    }

    return 0;
}
