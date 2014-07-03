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
    public String strStr(String haystack, String needle) {
        if (needle.equals("")) return haystack;
        int lenN = haystack.length();
        int lenM = needle.length();
        for (int i = 0; i <= lenN-lenM; i++) {
            int j = 0;
            for (; j < lenM; j++)
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
            if (j == lenM)
                return haystack.substring(i);
        }
        return null;
    }
}
