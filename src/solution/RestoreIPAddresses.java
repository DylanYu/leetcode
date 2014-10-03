package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

/**
 * Given a string containing only digits, restore it by returning 
 * all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author Dongliang Yu
 *
 */
public class RestoreIPAddresses {
    // straight forward solution using 3 loops
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<String>();
        if (s == null) return ret;
        int len = s.length();
        //if (len > 12 || len < 4) return ret; // later logic can handle these cases
        
        for (int i = 0; i < len-3 && i < 3; i++) {
            String s1 = s.substring(0, i+1);
            if (!isValidIPSeg(s1)) continue;
            for (int j = i+1; j < len-2 && j < i+4; j++) {
                String s2 = s.substring(i+1, j+1);
                if (!isValidIPSeg(s2)) continue;
                for (int k = j+1; k < len-1 && k < j+4; k++) {
                    String s3 = s.substring(j+1, k+1);
                    if (!isValidIPSeg(s3)) continue;
                    
                    String s4 = s.substring(k+1);
                    if (!isValidIPSeg(s4)) continue;
                    
                    String ip = String.format("%s.%s.%s.%s", s1, s2, s3, s4);
                    ret.add(ip);
                }
            }
        }
        
        return ret;
    }
    
    private boolean isValidIPSeg(String s) {
        if (s.length() > 3) return false;
        if (s.charAt(0) == '0' && s.length() != 1) return false; // if 0 appears in front, no other numbers are allowed
        int num = 0;
        for (int i = 0; i < s.length(); i++)
            num = num * 10 + (s.charAt(i)-'0');
        if (num > 255) return false;
        else return true;
    }
    
    /*
     * DFS solution just like PalindromePartitioning
     * https://oj.leetcode.com/problems/palindrome-partitioning/
     * 
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) return ret;
        restore(new ArrayList<String>(), s, ret);
        return ret;
    }
    
    private void restore(ArrayList<String> list, String s, List<String> ret) {
        if (list.size() == 4) {
            if (s.length() == 0) {
                String ip = String.format("%s.%s.%s.%s", list.get(0), list.get(1), list.get(2), list.get(3));
                ret.add(ip);
            }
            return;
        }
        if (list.size() + s.length() < 4) return; // early stop
        for (int i = 0; i < 3 && i < s.length(); i++) {
            String seg = s.substring(0, i+1);
            if (!isValidIpSeg(seg)) break; // break not continue
            list.add(seg);
            restore(list, s.substring(i+1), ret);
            list.remove(list.size()-1);
        }
    }
    */
}
