package solution;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a 
 * given number, target. Return the sum of the three integers. You may assume that each input 
 * would have exactly one solution.
 *
 *  For example, given array S = {-1 2 1 -4}, and target = 1.
 *  The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author Dongliang Yu
 *
 */
public class ThreeSumClosest {
    /**
     * The Brute-Force way takes O(N^3), but this solution takes only O(N^2).
     * The tricky lies in searching from both sides towards the middle in a sorted array.
     */
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int len = num.length;
        int minDistance = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < len; i++) {
            int j = i+1;
            int k = len-1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                int distance = Math.abs(sum - target);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestSum = sum;
                }
                if (sum < target) j++;      // search from both sides towards the middle
                else if (sum > target) k--;
                else return sum;            // match
            }
        }
        return closestSum;
    }
}
