package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

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
    /* 
     * typical O(N^3) solution (convert to two-sum problem)
     * 
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        int len = num.length;
        if (len < 4) return ret;
        Arrays.sort(num);
        int i = 0;
        while (i < len-3) {
            int j = i+1;
            while (j < len-2) {
                int k = j+1;
                int l = len-1;
                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];
                    // for the below 4 'do while's, we can use just x++ without while loop, but it will be slower
                    if (sum < target)
                        do { k++; } while (k < l && num[k-1] == num[k]);
                    else if (sum > target)
                        do { l--; } while (l > k && num[l] == num[l+1]);
                    else {
                        ret.add(Arrays.asList(num[i], num[j], num[k], num[l]));
                        do { k++; } while (k < l && num[k-1] == num[k]);
                        do { l--; } while (l > k && num[l] == num[l+1]);
                    }
                }
                do { j++; } while (j < len-2 && num[j-1] == num[j]); // must use while loop to eliminate duplicates
            }
            do { i++; } while (i < len-3 && num[i-1] == num[i]); // must use while loop to eliminate duplicates
        }
        return ret;
    }
    */
    
    class Pair {
        int a;
        int b;
        Pair(int a, int b) { this.a = a; this.b = b; }
    }
    
    class FourPair {
        int a; int b; int c; int d;
        FourPair(int a, int b, int c, int d) { this.a=a; this.b=b; this.c=c; this.d=d; }
        @Override
        public int hashCode() {
            int ret = 17;
            ret += ret * 31 + a;
            ret += ret * 31 + b;
            ret += ret * 31 + c;
            ret += ret * 31 + d;
            return ret;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof FourPair)) return false;
            FourPair that = (FourPair) obj;
            return this.a == that.a && this.b == that.b && this.c == that.c && this.d == that.d;
        }
    }
    
    // typical complexity is O(N^2), worst is O(N^3)
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        //if (num.length < 4) return ret;
        int len = num.length;
        Arrays.sort(num);
        Map<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
        Set<FourPair> set = new HashSet<FourPair>();
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int sum = num[i] + num[j];
                if (map.containsKey(target-sum)) {
                    for (Pair pair : map.get(target-sum)) {
                        FourPair four = new FourPair(pair.a, pair.b, num[i], num[j]);
                        set.add(four);
                    }
                }
            }
            for (int j = 0; j < i; j++) {
                // make pair of [j, i] for later search, 0<=j<i
                int sum = num[j] + num[i];
                if (!map.containsKey(sum))
                    map.put(sum, new LinkedList<Pair>());
                map.get(sum).add(new Pair(num[j], num[i]));
            }
        }
        for (FourPair e : set) {
            List<Integer> list = new LinkedList<Integer>();
            list.add(e.a);
            list.add(e.b);
            list.add(e.c);
            list.add(e.d);
            ret.add(list);
        }
        return ret;
    }
    
    /*
     * O(N^3)
     * 
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
    */
}
