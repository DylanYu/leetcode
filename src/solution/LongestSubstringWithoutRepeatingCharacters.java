package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters. For 
 * example, the longest substring without repeating letters for "abcabcbb" is "abc", which the 
 * length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * @author Dongliang Yu
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    // Almost same as the below one 
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        // assume we have only ACSII characters
        int[] table = new int[256];
        for (int i = 0; i < table.length; i++)
            table[i] = -1;
        char[] A = s.toCharArray();
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < A.length; i++) {
            if (table[A[i]] != -1) {   
                int newStart = table[A[i]] + 1;
                for (int j = start; j < newStart; j++)
                    table[A[j]] = -1;
                start = newStart;
            }
            table[A[i]] = i;
            maxLen = Math.max(maxLen, i-start+1);
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
