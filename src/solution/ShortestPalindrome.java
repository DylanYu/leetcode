package solution;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front 
 * of it. Find and return the shortest palindrome you can find by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * 
 * Given "abcd", return "dcbabcd".
 * 
 * @author Dongliang Yu
 *
 */
public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] c = s.toCharArray();
        int k = c.length-1;
        for (; k > 0; k--) {
            boolean isPalindrome = true;
            int i = 0;
            int j = k;
            while (i < j) {
                if (c[i++] != c[j--]) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome)
                break;
        }
        return new StringBuilder(s.substring(k+1)).reverse().append(s).toString();
    }
}
