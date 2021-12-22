package december;

import java.util.LinkedList;

public class IsValid {
    public boolean isValid(String s) {
        // if (s.length() % 2 == 1) return false;

        LinkedList<Character> stack = new LinkedList<>();

        for (char c:s.toCharArray()){
            if (c == '(') stack.add(')');
            if (c == '[') stack.add(']');
            if (c == '{') stack.add('}');
            if (stack.isEmpty() || stack.pop() != c) return false;
        }

        return stack.isEmpty();
    }
}
