package solution;

import java.util.*;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with any 
 * positive integer, replace the number by the sum of the squares of its digits, 
 * and repeat the process until the number equals 1 (where it will stay), or it loops 
 * endlessly in a cycle which does not include 1. Those numbers for which this process 
 * ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 
 * @author Dongliang Yu
 *
 */
public class HappyNumber {
	public boolean isHappy(int n) {
        //if (n == 1) return true;
        if (n <= 0) return false;
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(n);
        int curr = n;
        while (true) {
            int next = 0;
            while (curr != 0) {
                next += (int) Math.pow(curr - curr / 10 * 10, 2);
                curr /= 10;
            }
            if (next == 1) return true;
            if (visited.contains(next)) return false;
            visited.add(next);
            curr = next;
        }
    }
}
