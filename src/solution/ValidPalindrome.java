package solution;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author Dongliang Yu
 *
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        //if (s.length() == 0) return true; //
        char[] c = s.toLowerCase().toCharArray();
        int i = 0;
        int j = c.length-1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(c[i])) i++;
            while (j > i && !Character.isLetterOrDigit(c[j])) j--;
            if (i >= j) break;
            if (c[i] != c[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
