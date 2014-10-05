package solution;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * 
 * @author Dongliang Yu
 *
 */
public class WildcardMatching {
    // when not match, if there's previous star, try to use it to suck more characters
    public boolean isMatch(String s, String p) {
        int lenS = s.length(); int lenP = p.length();
        if (lenP == 0) return lenS == 0;
        char[] S = s.toCharArray(); char[] P = p.toCharArray();
        int i = 0; int j = 0;
        int stari = -1; int starj = -1;
        while (i < lenS) {
            if (j >= lenP || P[j] != '*') {
                if (j < lenP && (S[i] == P[j] || P[j] == '?')) { // match
                    i++;
                    j++;
                } else { // j >= lenP || not match, try to use star
                    if (stari == -1) return false;
                    stari = stari+1;
                    i = stari;
                    j = starj+1;
                }
            } else { // record star
                stari = i;
                starj = j;
                j++;
            }
        }
        while (j < lenP && p.charAt(j) == '*') j++;
        return j == lenP;
    }
    
    /**
     * Another explanation of above solution
     * 
    public boolean isMatch(String s, String p) {
        int lenS = s.length(); int lenP = p.length();
        if (lenP == 0) return lenS == 0;
        char[] S = s.toCharArray(); char[] P = p.toCharArray();
        int i = 0; int j = 0;
        int stari = -1; int starj = -1;
        while (i < lenS) {
            if (j >= lenP || (S[i] != P[j] && P[j] != '?' && P[j] != '*')) { // not match, try to use star
                if (stari == -1) return false;
                stari = stari+1;
                i = stari;
                j = starj+1;
            } else if (P[j] == '*') {
                stari = i;
                starj = j;
                j++;
            } else { // match
                i++;
                j++;
            }
        }
        while (j < lenP && p.charAt(j) == '*') j++;
        return j == lenP;
    }
    */
    
    /*
     * recursive way, not efficient for large input
    public boolean isMatch(String s, String p) {
        int lenS = s.length(); int lenP = p.length();
        if (lenP == 0) return lenS == 0;
        if (lenS == 0) {
            //if (lenP == 0) return true;
            int i = 0;
            while (i < lenP)
                if (p.charAt(i++) != '*') return false;
            return true;
        }
        if (p.charAt(lenP-1) != '*' && p.charAt(lenP-1) != '.') {
            if (s.charAt(lenS-1) != p.charAt(lenP-1))
                return false;
        }
        char c1 = s.charAt(0);
        char c2 = p.charAt(0);
        if (c1 == c2 || c2 == '?') return isMatch(s.substring(1), p.substring(1));
        else if (c2 == '*') {
            return isMatch(s.substring(1), p.substring(1))
                    || isMatch(s, p.substring(1))
                    || isMatch(s.substring(1), p);
        } else
            return false;
    }*/

    public static void main(String[] args) {
        //String s = "";
        //String p = "";
        //String s = "hi";
        //String p = "*?"; //true
        String s = "bbaaababaaabaaaababaabbabababbbaabaababbbaabababbb";
        String p = "**b*aa*b***aa****b*aaaa*"; // true
        //String s = "bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab";
        //String p = "b*b*ab**ba*b**b***bba"; // false
        //String s = "abbbaaaaaaaabbbabaaabbabbbaabaabbbbaabaabbabaabbabbaabbbaabaabbabaabaabbbbaabbbaabaaababbbbabaaababbaaa";
        //String p = "ab**b*bb*ab**ab***b*abaa**b*a*aaa**bba*aa*a*abb*a*a"; // true
        //String s = "abcdeeeeecf";
        //String p = "a*d?*ecf"; // true
        System.out.println(new WildcardMatching().isMatch(s, p));
    }
}
