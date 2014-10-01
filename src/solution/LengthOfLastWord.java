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
        //if (s.length() == 0) return 0;
        char[] c = s.toCharArray();
        int j = c.length-1;
        while (j >= 0 && c[j] == ' ') j--;
        int i = j; // not j-1 to deal with all space case
        while (i >= 0 && c[i] != ' ') i--;
        return j-i;
    }
}
