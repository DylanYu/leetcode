package solution;

/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is 
 * not part of haystack.
 * 
 * @author Dongliang Yu
 *
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        //if (needle.equals("")) return haystack; // later logic could handle this case
        int lenM = haystack.length();
        int lenN = needle.length();
        for (int i = 0; i <= lenM-lenN; i++) {
            int j = 0;
            while (j < lenN) {
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
                j++;
            }
            if (j == lenN) // if lenN == 0, return entire haystack at i = 0
                return i;
        }
        return -1;
    }
}
