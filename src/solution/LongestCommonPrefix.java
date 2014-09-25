package solution;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * @author Dongliang Yu
 *
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int minLen = Integer.MAX_VALUE;
        for (String e : strs)
            minLen = Math.min(minLen, e.length());
        int index = 0;
        boolean flag = true;
        while (index < minLen) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(index) != strs[i-1].charAt(index)) {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
            index++;
        }
        return strs[0].substring(0, index);
    }
}
