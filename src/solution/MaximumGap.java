package solution;

/**
 * Given an unsorted array, find the maximum difference between the successive 
 * elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit 
 * in the 32-bit signed integer range.
 * 
 * @author Dongliang Yu
 *
 */
public class MaximumGap {
    // https://oj.leetcode.com/discuss/18499/bucket-sort-java-solution-with-explanation-o-time-and-space
    // the maximum gap will be no smaller than ceiling[(max - min ) / (N - 1)]
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2) return 0;
        int len = num.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int e : num) {
            min = Math.min(min, e);
            max = Math.max(max, e);
        }
        int gap = (int) Math.ceil((double) (max-min) / (len-1)); // len-1
        int bucketNum = (int) Math.ceil((double) (max-min) / gap);
        int[] bucketMin = new int[bucketNum];
        int[] bucketMax = new int[bucketNum];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, 0);
        for (int e : num) {
            if (e == min || e == max) continue;
            int index = (e-min) / gap;
            bucketMin[index] = Math.min(bucketMin[index], e);
            bucketMax[index] = Math.max(bucketMax[index], e);
        }
        int previous = min;
        int maxGap = 0;
        for (int i = 0; i < bucketNum; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == 0)
                // empty bucket
                continue;
            maxGap = Math.max(maxGap, bucketMin[i]-previous);
            previous = bucketMax[i];
        }
        // final gap
        maxGap = Math.max(maxGap, max-previous);
        return maxGap;
    }
}
