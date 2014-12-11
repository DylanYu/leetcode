package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S, find the length of the longest substring T that contains at most two distinct characters.
 * For example,
 * Given S = “eceba”,
 * T is “ece” which its length is 3.
 * 
 * @author Dongliang Yu
 *
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) return -1;
        int len = s.length();
        if (len <= 2) return len;
        int start = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
                while (map.size() > 2) {
                    char a = s.charAt(start);
                    if (map.get(a) == 1) map.remove(a);
                    else map.put(a, map.get(a)-1);
                    start++;
                }
            }
            maxLen = Math.max(maxLen, i-start+1);
        }
        return maxLen;
    }
    
    public static void main(String[] args) {
        String S = "eceba"; // 3
        S = "aaaaa";
        S = "aaaaab"; // 6
        S = "aaaaabc"; // 6
        S = "baaaac"; // 5
        S = "abaddeeeff"; // 5
        //Strnig T = "ece";
        System.out.println(new LongestSubstringWithAtMostTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct(S));
    }
}
