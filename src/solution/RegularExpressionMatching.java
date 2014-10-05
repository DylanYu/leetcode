package solution;

/**
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
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
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * 
 * @author Dongliang Yu
 *
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        if (lenP == 0) return lenS == 0;
        if (lenS == 0) {
            int i = 0; // lenP==0 is ok
            while (i < lenP) {
                if (i+1 >= lenP) return false;
                if (p.charAt(i+1) != '*') return false;
                else i+=2;
            }
            return true;
        }
        
        if (p.charAt(lenP-1) != '*') { // crucial early stop
            if (s.charAt(lenS-1) != p.charAt(lenP-1) && p.charAt(lenP-1) != '.')
                return false;
        }
        char c1 = s.charAt(0);
        char c2 = p.charAt(0);
        if (lenP >= 2 && p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2))) return true; // aggressively
            if (c1 == c2 || c2 == '.')
                return isMatch(s.substring(1), p.substring(2))
                        || isMatch(s.substring(1), p);
                        //|| isMatch(s, p.substring(2))
            return false;
            /*
            if (c1 == c2 || c2 == '.')
                return isMatch(s.substring(1), p.substring(2))
                        || isMatch(s.substring(1), p)
                        || isMatch(s, p.substring(2));
            else
                return isMatch(s, p.substring(2));
            */
        } else {
            if (c1 == c2 || c2 == '.')
                return isMatch(s.substring(1), p.substring(1));
            else
                return false;
        }
    }
    
    public static void main(String[] args) {
        //String s = "a";
        //String p = "ab*";
        //String s = "aa";
        //String p = ".*";
        //String s = "aa";
        //String p = "a";
        //String s = "ab";
        //String p = ".*c";
        //String s = "aab";
        //String p = "c*a*b";
        //String s = "bbbba";
        //String p = ".*a*a";
        //String s = "aaaaaaaaaaaaab";
        //String p = "a*a*a*a*a*a*a*a*a*a*a*a*b"; // true
        String s = "aasdfasdfasdfasdfas";
        String p = "aasdf.*asdf.*asdf.*asdf.*s"; // true
        System.out.println(new RegularExpressionMatching().isMatch(s, p));
    }
}
