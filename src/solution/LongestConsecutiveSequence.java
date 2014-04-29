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
        HashSet<Integer> set = new HashSet<Integer>();
        for (Integer e : num)
            set.add(e);
        int max = 0;
        int i = 0;
        while (i < num.length) {
            int cur = num[i];
            set.remove(cur);
            int len = 1;
            int left = cur - 1;
            int right = cur + 1;
            while (set.contains(left)) {
                len++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                len++;
                set.remove(right);
                right++;
            }
            if (len > max)
                max = len;
            i++;
        }
        return max;
    }
}
