package solution;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine 
 * if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" 
 * and "([)]" are not.
 * 
 * @author Dongliang Yu
 *
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } else {
                if (stk.isEmpty()) return false;
                char last = stk.pop();
                if (c == ')' && last != '(') return false;
                else if (c == '}' && last != '{') return false;
                else if (c == ']' && last != '[') return false;
            }
        }
        return stk.isEmpty();
    }
}
