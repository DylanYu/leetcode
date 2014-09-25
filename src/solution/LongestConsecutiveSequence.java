package solution;

import java.util.HashSet;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * <p>
 * For example,
 * <p>Given [100, 4, 200, 1, 3, 2],
 * <p>The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * 
 * @author Dongliang Yu
 * 
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] num) {
        // TODO: if duplicate elements are allowed we should use HashMap to store frequency
        HashSet<Integer> set = new HashSet<Integer>();
        for (Integer e : num)
            set.add(e);
        int maxLen = 0;
        for (int i = 0; i < num.length; i++) {
            int curr = num[i];
            if (!set.contains(curr)) continue;
            set.remove(curr); // set.remove(e) just returns false when element is not contained, 
                              // without exception throwed, so above line is actually not necessary
            int left = curr - 1;
            while (set.contains(left)) {
                set.remove(left);
                left--;
            }
            int right = curr + 1;
            while (set.contains(right)) {
                set.remove(right);
                right++;
            }
            maxLen = Math.max(maxLen, right-left-1);
        }
        return maxLen;
    }
}
