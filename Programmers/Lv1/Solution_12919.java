package Lv1;

public class Solution_12919 {
    public String solution(String[] seoul) {
        StringBuilder answer = new StringBuilder();

        answer.append("김서방은 ");

        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                answer.append(i);
                break;
            }
        }

        answer.append("에 있다.");

        return answer.toString();
    }
}
