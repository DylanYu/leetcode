package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

/**
 * 3Sum
 * <p>
 * Given an array S of n integers, are there elements a, b, c in S such that 
 * a + b + c = 0? Find all unique triplets in the array which gives the sum 
 * of zero.
 * <p>
 * Note:
 * <p>Elements in a triplet (a,b,c) must be in non-descending order. 
 * (ie, a ≤ b ≤ c)
 * <p>The solution set must not contain duplicate triplets.
 * <p>For example, given array S = {-1 0 1 2 -1 -4},
 * <p>
 *  A solution set is:
 *  [(-1, 0, 1),(-1, -1, 2)]
 * 
 * @author Dongliang Yu
 *
 */
public class ThreeSum {
    // convert this problem to two-sum, no Set or Map is used
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        Arrays.sort(num);
        int i = 0;
        while (i < num.length-2) {
            int target = -num[i];
            int j = i+1;
            int k = num.length-1;
            while (j < k) {
                int twoSum = num[j] + num[k];
                if (twoSum > target)  {
                    k--;
                    while (k > j && num[k] == num[k+1]) k--;
                } else if (twoSum < target) {
                    j++;
                    while (j < k && num[j] == num[j-1]) j++;
                } else {
                    List<Integer> subRet = new LinkedList<Integer>();
                    subRet.add(num[i]);
                    subRet.add(num[j]);
                    subRet.add(num[k]);
                    ret.add(subRet);
                    // skip duplicates
                    do { j++; } while (j < k && num[j] == num[j-1]); // DO NOT forget me
                    do { k--; } while (k > j && num[k] == num[k+1]); // DO NOT forget me
                }
            }
            i++;
            while (i < num.length-2 && num[i-1] == num[i]) i++; // skip duplicates
        }
        return ret;
    }
    
    /*
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        int length = num.length;
        if (length <= 2)
            return results;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            if (map.get(num[i]) != null)
                map.put(num[i], map.get(num[i]) + 1);
            else
                map.put(num[i], 1);
        }
        Arrays.sort(num);
        int a = num[0] + 1; // just make it different from num[0]
        for (int i = 0; i < length - 2; i++) {
            if (num[i] == a) // skip duplicates
                continue;
            a = num[i];
            int b = num[i + 1] + 1; // just make it different from num[i + 1];
            for (int j = i + 1; j < length - 1; j++) { // a <= b
                if (num[j] == b) // skip duplicates
                    continue;
                b = num[j];
                int c = - (a + b);
                if (c >= b && map.containsKey(c)) {
                    if (b != c ||
                        b == c && a != b && map.get(c) >= 2 ||
                        b == c && a == b && map.get(c) >= 3) {
                        ArrayList<Integer> newResult = new ArrayList<Integer>();
                        newResult.add(a);
                        newResult.add(b);
                        newResult.add(c);
                        results.add(newResult);
                    }
                    // straight forward way
                    //if (c == a){
                    //    if (map.get(a) >= 3)
                    //        addMoreResult(results, a, b, c); // a == b == c (0, 0, 0)
                    //    else
                    //        continue;
                    //} else if (c == b) {
                    //    if (map.get(b) >= 2)
                    //        addMoreResult(results, a, b, c); // a != b,  b = c
                    //    else
                    //        continue;
                    //} else {
                    //    addMoreResult(results, a, b, c); // b != c
                    //}
                }
            }
        }
        return results;
    }
    */
}
