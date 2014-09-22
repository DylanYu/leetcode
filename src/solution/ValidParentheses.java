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
        if (s == null || s.length() == 0) return false;
        char[] l = {'(', '{', '['};
        char[] r = {')', '}', ']'};
        char[] c = s.toCharArray();
        Stack<Character> stk = new Stack<Character>();
        for (int i = 0; i < c.length; i++) {
            char curr = c[i];
            if (curr == l[0] || curr == l[1] || curr == l[2]) {
                stk.push(curr);
            } else {
                if (stk.isEmpty()) {
                        return false;
                } else {
                    char last = stk.pop();
                    if (!(last == l[0] && curr == r[0] 
                            || last == l[1] && curr == r[1] 
                            || last == l[2] && curr == r[2]))
                        return false;
                }
            }
        }
        return stk.isEmpty(); //
    }
}
