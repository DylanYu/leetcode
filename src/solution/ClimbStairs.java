package solution;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * @author Dongliang Yu
 *
 */
public class ClimbStairs {
    /**
     * for A[n], we take a look at all possibilities end with 1 step, it happens to be A[n-1].
     * We then take a look at all possibilities end with 2 steps, it happends to be A]n-2].
     * So we have A[n] = A[n-1] + A[n-2], which is actually Fibonacci. 
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int stepOne = 1;
        int stepTwo = 2;
        int i = 3;
        while (i <= n) {
            int next = stepOne + stepTwo;
            stepOne = stepTwo;
            stepTwo = next;
            i++;
        }
        return stepTwo;
    }
}
