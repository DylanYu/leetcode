package solution;

import java.util.*;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus + or 
 * minus sign -, non-negative integers and empty spaces .
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * 
 * Note: Do not use the eval built-in library function.
 * 
 * @author Dongliang Yu
 *
 */
public class BasicCalculator {
	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        Stack<String> stk = new Stack<String>();
        int i = 0;
        while (i < arr.length) {
            char c = arr[i];
            if (c == ' ') {
                i++;
                continue;
            } else if (c == ')') {
                stk.push(simpleCal(stk));
                i++;
            } else if (c == '+' || c == '-' || c == '(') {
                stk.push(c+"");
                i++;
            } else if (c >= '0' || c <= '9') {
                StringBuilder sb = new StringBuilder();
                while (i < arr.length && (arr[i] >= '0' && arr[i] <= '9'))
                    sb.append(arr[i++]);
                stk.push(sb.toString());
            }
        }
        return Integer.parseInt(simpleCal(stk));
    }
    
    private String simpleCal(Stack<String> stk) {
        Stack<String> stk2 = new Stack<String>();
        while (!stk.isEmpty()) {
            String s = stk.pop();
            if (s.equals("(")) break;
            stk2.push(s);
        }
        while (stk2.size() > 0) {
            String a = stk2.pop();
            if (stk2.isEmpty()) return a;
            String op = stk2.pop();
            String b = stk2.pop();
            stk2.push(cal(a, op, b));
        }
        return "0";
    }
    
    private String cal(String a , String op, String b) {
        if (op.equals("+"))
            return Integer.parseInt(a) + Integer.parseInt(b) + "";
        else
            return Integer.parseInt(a) - Integer.parseInt(b) + "";
    }
}
