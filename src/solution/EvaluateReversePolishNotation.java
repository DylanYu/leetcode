package solution;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author Dongliang Yu
 *
 */
public class EvaluateReversePolishNotation {
    // solution using a stack
    // in real projects we should worry about invalid expressions and throw corresponding exceptions
    public int evalRPN(String[] tokens) {
        Stack<String> stk = new Stack<String>();
        for (String cur : tokens) {
            if (!isOp(cur)) {
                stk.push(cur);
            } else {
                String b = stk.pop(); // if stack empty
                String a = stk.pop();
                stk.push(calculate(a, cur, b) + "");
            }
        }
        return Integer.parseInt(stk.pop()); // if stack.size()>1
    }
    
    /* solution does not apply a explicit stack (which in fact is stack like)
    public int evalRPN(String[] tokens) {
        int x = 0;
        while (x < tokens.length) {
            String cur = tokens[x];
            if (isOp(cur)) {
                String a = null;
                String b = null;
                int i;
                for (i = x-1; i >= 0; i--)
                    if (!isOp(tokens[i]) && !tokens[i].equals(".")) {
                        b = tokens[i];
                        break;
                    }
                int j;
                for (j = i-1; j >= 0; j--)
                    if (!isOp(tokens[j]) && !tokens[j].equals(".")) {
                        a = tokens[j];
                        break;
                    }
                tokens[x] = calculate(a, cur, b) + "";
                tokens[i] = ".";
                tokens[j] = ".";
            }
            x++;
        }
        return Integer.parseInt(tokens[tokens.length-1]);
    }
    */

    private boolean isOp(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    
    private int calculate(String s1, String op, String s2) {
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        if (op.equals("+")) return a+b;
        if (op.equals("-")) return a-b;
        if (op.equals("*")) return a*b;
        /*if (op.equals("/"))*/ return a/b; // should caution about b=0
    }
    
    public static void main(String[] args) {
//        String[] arr = {"0","3","/"};
        String[] arr = {"4","13","5","/","+"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(arr));
    }
}
