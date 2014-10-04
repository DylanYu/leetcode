package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the 
 * characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always be only one 
 * unique minimum window in S.
 * 
 * @see Substring with Concatenation of All Words 
 * 
 * @author Dongliang Yu
 *
 */
public class MinimumWindowSubstring {
	
	private int count;
    
    public String minWindow(String S, String T) {
        if (S == null || T == null) return null;
        int lenS = S.length();
        int lenT = T.length();
        if (lenS == 0 || lenT == 0 || lenT > lenS) return "";
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        
        Map<Character, Integer> limitMap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length; i++)
        	if (!limitMap.containsKey(t[i])) limitMap.put(t[i], 1);
            else limitMap.put(t[i], limitMap.get(t[i])+1);
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        count = 0;
        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        
        int start = 0;
        int i = 0;
        while (i < lenS) {
            while (i < lenS && count < lenT) // increase i to collect enough characters in T
                mapInc(map, limitMap, s[i++]);
            if (i == lenS && count < lenT) break; // not possible
            while (start < lenS && count == lenT) // increase start to eliminate redundant characters
                mapDec(map, limitMap, s[start++]);
            
            if (i-start+1 < minLen) {
                minLen = i-start+1;
                minStr = S.substring(start-1, i);
            }
        }
        return minStr;
    }
    
    private void mapInc(Map<Character, Integer> map, Map<Character, Integer> limitMap, char key) {
    	if (!limitMap.containsKey(key)) return;
        if (!map.containsKey(key)) map.put(key, 1);
        else map.put(key, map.get(key)+1);
        if (map.get(key) <= limitMap.get(key)) // actions lead to exceeding limit does not count
            count++;
    }
    
    private void mapDec(Map<Character, Integer> map, Map<Character, Integer> limitMap, char key) {
    	if (!limitMap.containsKey(key)) return;
        if (!map.containsKey(key)) return;
        if (map.get(key) <= limitMap.get(key))
            count--;
        map.put(key, map.get(key)-1);
    }
	
	/**
    // idea from https://oj.leetcode.com/discuss/5469/is-the-length-of-t-considered-constant-or-m?show=5502#a5502
    public String minWindow(String S, String T) {
        //if (S.length() < T.length()) return ""; // handled by if(negativeCount>0)break in while loop
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t) {
            // decrease to negative, for duplicates it could be a very negative number
            mapDec(map, c);
        }
        int negativeCount = map.keySet().size();
        int minWinLen = Integer.MAX_VALUE;
        String minWinStr = "";
        int i = 0;
        int j = 0;
        while (i < s.length && j < s.length) {
            while (negativeCount > 0 && j < s.length) {
                mapInc(map, s[j]);
                // == not >=, cuz it's promoted from negative to 0, and >= will mess with other not in T characters
                if (map.get(s[j]) == 0) negativeCount--;
                j++;
            }
            // negativeCount should be 0 here if there's possible window from i to j
            if (negativeCount > 0) break; // scanned not enough characters in T, no possible window
            while (negativeCount == 0 && i < s.length) {
                mapDec(map, s[i]);
                if (map.get(s[i]) < 0) negativeCount++;
                i++;
            }
            int len = j - i + 1;
            if (len < minWinLen) {
                minWinLen = len;
                minWinStr = S.substring(i-1, j);
            }
        }
        return minWinStr;
    }
    
    private void mapInc(Map<Character, Integer> map, char c) {
        if (!map.containsKey(c)) map.put(c, 1);
        else map.put(c, map.get(c)+1);
    }
    
    private void mapDec(Map<Character, Integer> map, char c) {
        if (!map.containsKey(c)) map.put(c, -1);
        else map.put(c, map.get(c)-1);
    }
    */
    
    public static void main(String[] args) {
        //String S = "ab";
        //String T = "a";
        String S = "aa";
        String T = "aa";
        //String S = "bba";
        //String T = "ab";
        System.out.println(new MinimumWindowSubstring().minWindow(S, T));
    }
}
