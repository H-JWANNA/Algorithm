package Lv2;

import java.util.*;

public class Solution_12909 {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if('(' == current) stack.push("(");
            else if(')' == current && !stack.empty()) {
                stack.pop();
            } else return false;
        }

        return stack.empty();
    }
}
