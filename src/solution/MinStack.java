package solution;

import java.util.Stack;

/**
 * 
 * @author Dongliang Yu
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 */
public class MinStack {
    private Stack<Integer> stk;
    private Stack<Integer> minStk;
    
    public MinStack() {
        stk = new Stack<Integer>();
        minStk= new Stack<Integer>();
    }
    
    public void push(int x) {
        stk.push(x);
        // only store necessary min elements to save space
        if (minStk.isEmpty() || x <= minStk.peek()) // just < is hard to implement
            minStk.push(x);
    }

    public void pop() {
        if (stk.isEmpty()) return; // Exception
        int x = stk.pop();
        if (minStk.peek() == x)
            minStk.pop();
    }

    public int top() {
        if (stk.isEmpty()) return Integer.MAX_VALUE; // Exception
        return stk.peek();
    }

    public int getMin() {
        if (minStk.isEmpty()) return Integer.MAX_VALUE; // Exception
        return minStk.peek();
    }
}
