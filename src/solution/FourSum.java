package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that 
 * a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 * 
 * @author Dongliang Yu
 *
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        //if (num.length < 4) return ret; // later logic can handle this case
        int len = num.length;
        Arrays.sort(num);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // num[i]:i, for same num[i] and num[j], put max(i, j)
        for (int i = 0; i < len; i++)
            map.put(target-num[i], i);
        for (int i = 0; i < len; i++) {
            if (i-1 >= 0 && num[i-1] == num[i]) continue; // eliminate duplicates
            for (int j = i+1; j < len; j++) {
                if (j-1 > i && num[j-1] == num[j]) continue; // eliminate duplicates
                for (int k = j+1; k < len; k++) {
                    if (k-1 > j && num[k-1] == num[k]) continue; // eliminate duplicates
                    int sum = num[i] + num[j] + num[k];
                    if (map.containsKey(sum) && map.get(sum) > k) { // eliminate duplicates too
                        List<Integer> subRet = new LinkedList<Integer>();
                        subRet.add(num[i]);
                        subRet.add(num[j]);
                        subRet.add(num[k]);
                        subRet.add(num[map.get(sum)]);
                        ret.add(subRet);
                    }
                }
            }
        }
        return ret;
    }
}
