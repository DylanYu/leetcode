package solution;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 * @author Dongliang Yu
 *
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        int j = s.length()-1;
        while (j >= 0) {
            if (s.charAt(j) != ' ') break;
            j--;
        }
        if (j < 0) return 0;
        int i = j-1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') break;
            i--;
        }
        return j-i;
    }
}
