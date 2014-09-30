package solution;

/**
 * Given an array of non-negative integers, you are initially positioned at the 
 * first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * @author Dongliang Yu
 *
 */
public class JumpGame {
    // as easy as you could image
    public boolean canJump(int[] A) {
    	if (A.length == 0) return false;
        int dst = A.length-1;
        int farthest = 0;
        int i = 0;
        while (i <= farthest) {
            if (farthest >= dst) return true;
            farthest = Math.max(farthest, i+A[i]);
            i++;
        }
        return false;
    }
    
    /*
     * DP solution, but can't scale to large case, which could take O(N^2)
     *  
    public boolean canJump(int[] A) {
        // 0 - init; -1 - cannot reach to final; 1 - can reach to final
        int[] dp = new int[A.length];
        dp[A.length-1] = 1;
        return getResult(dp, A, 0) == 1;
    }
    
    private int getResult(int[] dp, int[] A, int index) {
        if (index >= A.length) return -1;
        if (dp[index] != 0) return dp[index];
        int forward = Math.min(A[index]+index, A.length-1);
        dp[index] = -1;
        for (int i = forward; i > index; i--) // check
            if (getResult(dp, A, i) == 1) {
                dp[index] = 1;
                break;
            }
        return dp[index];
    }
    */
    
    public static void main(String[] args) {
        int[] A = {2,3,1,1,4};
        //int[] A = {3,2,1,0,4};
        System.out.println(new JumpGame().canJump(A));
    }
}
