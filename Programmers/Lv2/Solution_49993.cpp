#include <vector>
#include <algorithm>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;


    for(int i = 0; i < skill_trees.size(); i++) {
        string current_skill = skill_trees[i];

        int index = 0;
        answer++;

        for (int j = 0; j < current_skill.length(); j++) {
            int cur = skill.find(current_skill[j]);

            if (cur == -1) {
                continue;
            }

            if (cur != index) {
                answer--;
                break;
            }
            else {
                index++;
            }
        }
    }

    return answer;
}
