import java.util.*;

public class Daily_28 {

    public boolean balancedBrackets(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);

            try {
                switch(c) {
                    case '(': case '[': case '{':
                        stack.push(c);
                        break;

                    case ')':
                        if(stack.pop() != '(') return false;
                        break;
                    case ']':
                        if(stack.pop() != '[') return false;
                        break;
                    case '}':
                        if(stack.pop() != '{') return false;
                        break;
                }
            } catch (EmptyStackException e) { return false; }
        }

        return stack.empty();
    }
}

