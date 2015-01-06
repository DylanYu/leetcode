package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters. For 
 * example, the longest substring without repeating letters for "abcabcbb" is "abc", which the 
 * length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * @author Dongliang Yu
 * @see SubstringWithConcatenationOfAllWords
 */
public class LongestSubstringWithoutRepeatingCharacters {
    // Almost same as the below one 
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        // assume we have only ACSII characters
        boolean[] table = new boolean[256];
        char[] c = s.toCharArray();
        int maxLen = 0;
        int start = 0;
        int i = 0;
        while (i < c.length) {
            if (!table[c[i]]) {   
                table[c[i]] = true;
                i++;
            } else {
                while (c[start] != c[i])
                    table[c[start++]] = false;
                start++;
                i++;
            }
            maxLen = Math.max(maxLen, i-start);
        }
        return maxLen;
    }
    
    /**
     * Same idea as 'Substring With Concatenation Of All Words',
     * (we can use a boolean array to replace the Set)
     * 
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] A = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < A.length; i++) {
            if (!set.contains(A[i])) {
                set.add(A[i]);
            } else {
                char c = A[start];
                while (c != A[i]) {
                    set.remove(c);
                    start++;
                    c = A[start];
                }
                start++;
            }
            maxLen = Math.max(maxLen, i-start+1);
        }
        return maxLen;
    }
    */
}
