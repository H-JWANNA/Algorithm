package Lv2;

public class Solution_12951 {
    public String solution(String s) {
        String[] arr = s.split(" ");

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].isBlank()) {
                arr[i] = arr[i];
            } else {
                arr[i] = String.valueOf(arr[i].charAt(0)).toUpperCase()
                        + arr[i].substring(1).toLowerCase();
            }
        }

        String answer = String.join(" ", arr);

        if(s.charAt(s.length() - 1) == ' ') answer += " ";

        return answer;
    }
}
