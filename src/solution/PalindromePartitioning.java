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
        recurse(new ArrayList<String>(), s, ret);
        return ret;
    }
    
    private void recurse(ArrayList<String> list, String s, List<List<String>> ret) {
        if (s.length() == 0) {
            ret.add(list);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i+1);
            if (isPalindrome(left)) {
                ArrayList<String> copy = new ArrayList<String>(list);
                copy.add(left);
                recurse(copy, s.substring(i+1), ret);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i < j)
            if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }
}
