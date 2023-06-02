#include <queue>
#include <vector>
#include <iostream>

using namespace std;

vector<vector<int>> map;
int max_x;
int max_y;
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

struct Man {
    int x, y, count;
};

int solution(vector<vector<int>> maps) {
    max_x = maps[0].size();
    max_y = maps.size();
    map = maps;

    queue<Man> q;
    q.push({0, 0, 1});
    vector<vector<bool>> visited(max_y, vector<bool>(max_x));
    visited[0][0] = true;

    while (!q.empty()) {
        Man cur = q.front();
        q.pop();

        // cout << cur.x << ", " << cur.y << ", " << cur.count << endl;

        for (int i = 0; i < 4; i++) {
            int next_x = cur.x + dx[i];
            int next_y = cur.y + dy[i];

            if (next_x < 0 || next_y < 0 || next_y >= max_y || next_x >= max_x) {
                continue;
            }

            if (map[next_y][next_x] == 0 || visited[next_y][next_x]) {
                continue;
            }

            if (next_x == max_x - 1 && next_y == max_y - 1) {
                return cur.count + 1;
            }

            q.push({next_x, next_y, cur.count + 1});
            visited[next_y][next_x] = true;
        }
    }

    // 모든 탐색 이후에 목적지에 도착하지 못했다면 도달할 수 없는 것으로 판단해 -1 반환
    return -1;
}
