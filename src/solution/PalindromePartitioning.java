package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 *   [
 *     ["aa","b"],
 *     ["a","a","b"]
 *   ]
 * 
 * @author Dongliang Yu
 *
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new LinkedList<List<String>>();
        if (s == null || s.length() == 0) return ret;
        ArrayList<String> list = new ArrayList<String>();
        list.add(s);
        partition(list, ret);
        return ret;
    }
    
    // DFS
    public void partition(ArrayList<String> list, List<List<String>> ret) {
        String cur = list.get(list.size()-1);
        if (cur == null) return;
        if (isPalindrome(cur)) {
            ret.add(list);
        }
        List<String[]> pairs = split(cur);
        for (String[] pair : pairs) {
            ArrayList<String> copy = new ArrayList<String>(list); // copy in ArrayList is more 
                                                                  // efficient than LinkedList
            copy.set(copy.size()-1, pair[0]); // remove last and add
            copy.add(pair[1]);
            partition(copy, ret);
        }
    }
    
    private List<String[]> split(String s) {
        List<String[]> ret = new LinkedList<String[]>();
        // exclude the last index because we don't need an empty strs[1]
        for (int i = 0; i < s.length()-1; i++) {
            if (isPalindrome(s, 0, i)) {
                String[] strs = new String[2];
                strs[0] = s.substring(0, i+1);
                strs[1] = s.substring(i+1);
                ret.add(strs);
            }
        }
        return ret;
    }
    
    private boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length()-1);
    }
    
    private boolean isPalindrome(String s, int lo, int hi) {
        if (lo < 0 || hi >= s.length()) return false;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }
}
