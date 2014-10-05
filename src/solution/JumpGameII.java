package solution;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of 
 * the array.
 *
 * Each element in the array represents your maximum jump length at that position. Your goal is 
 * to reach the last index in the minimum number of jumps.
 *
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 
 * 3 steps to the last index.)
 * 
 * @author Dongliang Yu
 *
 */
public class JumpGameII {
    // Kind of BFS. For k steps, calculate the furthest index we can reach
    public int jump(int[] A) {
        if (A.length == 0) return -1;
        int furthest = 0;
        int step = 0;
        int i = 0;
        while (i <= furthest) {
            if (furthest >= A.length-1) return step;
            int stopIdx = furthest; // stop at every step
            while (i <= stopIdx) {
                furthest = Math.max(furthest, i + A[i]);
                i++;
            }
            step++;
        }
        return -1;
    }
    
    /**
     * DP solution, O(N^2), not efficient, stackOverFlowError for large test case
     * 
    public int jump(int[] A) {
        int[] DP = new int[A.length];
        for (int i = 0; i < A.length; i++)
            DP[i] = -2;
        DP[A.length-1] = 0;
        return jump(DP, A, 0);
    }
    
    // -2: init; -1: can't reach; positive: jumps
    private int jump(int[] DP, int[] A, int i) {
        if (i >= A.length) return 0;
        if (DP[i] != -2) return DP[i];
        int min = Integer.MAX_VALUE;
        boolean canReach = false;
        for (int step = 1; step <= A[i]; step++) {
            int jumpsAfterStep = jump(DP, A, i+step);
            if (jumpsAfterStep != -1) {
                canReach = true;
                int jumps = 1 + jumpsAfterStep;
                if (jumps < min) min = jumps;
            }
        }
        if (canReach) DP[i] = min;
        else DP[i] = -1; // min is Integer.MAX_VALUE, not reasonable
        return DP[i];
    }
    */
    
    /**
     * BFS, O(N^2), not efficient
     * 
    public int jump(int[] A) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        queue.add(-1); // -1 as the marker of one layer (step)
        Set<Integer> set = new HashSet<Integer>();
        set.add(0);
        int step = 0;
        while (!queue.isEmpty()) {
            while (queue.getFirst() != -1) {
                int cur = queue.removeFirst();
                if (cur >= A.length-1) return step;
                for (int i = A[cur]; i > 0; i--) {
                    if (!set.contains(cur + i)) {
                        queue.add(cur + i);
                        set.add(cur + i);
                    }
                }
            }
            queue.removeFirst();
            if (queue.isEmpty()) return -1;
            queue.add(-1);
            step++;
        }
        return -1;
    }
    */
    
    public static void main(String[] args) {
        int[] A = {2,3,1,1,4}; // 2
        //int[] A = {3,2,1,0,4}; // -1
        System.out.println(new JumpGameII().jump(A));
    }
}
