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
        if (s.length() >= 2 && s.charAt(0) == '0') return false;
        if (Integer.parseInt(s) > 255) return false;
        return true;
    }
    
    /*
     * DFS solution just like PalindromePartitioning
     * https://oj.leetcode.com/problems/palindrome-partitioning/
     * 
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<String>();
        if (s == null || s.length() > 12 || s.length() < 4) return ret;
        ArrayList<String> list = new ArrayList<String>();
        list.add(s);
        restore(list, ret);
        return ret;
    }
    
    private void restore(ArrayList<String> list, List<String> ret) {
        if (list.size() >= 5) return;
        String cur = list.get(list.size()-1);
        if (list.size() == 4 && Integer.parseInt(cur) <= 255) {
            if (cur.charAt(0) == '0' && cur.length() >= 2) return; // special case described below
            StringBuffer sb = new StringBuffer();
            for (String s : list) {
                sb.append(s);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            ret.add(sb.toString());
            return;
        }
        int strLen = cur.length();
        int prevIpSegNo = list.size()-1;
        if (strLen > (4-prevIpSegNo)*3) return;
        if (strLen < (4-prevIpSegNo)) return;
        
        // special case of "0XXX", each segment of output can be just "0", but can't start with '0'
        if (cur.charAt(0) == '0') {
            if (cur.length() <= 1) return; // for "0" as the last valid segment, already handled before
            list.set(list.size()-1, "0"); // remove last and add;
            list.add(cur.substring(1));
            restore(list, ret);
            return;
        }
        // general case
        for (int i = 0; i < 3 && i < cur.length()-1; i++) {
            String l = cur.substring(0, i+1);
            int ipSeg = Integer.parseInt(l);
            if (ipSeg <= 255) {
                ArrayList<String> copy = new ArrayList<String>(list);
                copy.set(copy.size()-1, l); // remove last and add;
                copy.add(cur.substring(i+1));
                restore(copy, ret);
            }
        }
    }
    */
}
