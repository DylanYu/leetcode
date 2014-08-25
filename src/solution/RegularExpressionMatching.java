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
        if (s == null || p == null) return false;
        char[] S = s.toCharArray();
        char[] P = p.toCharArray();
        return isMatch(S, P, 0, 0);
    }
    
    public boolean isMatch(char[] s, char[] p, int m, int n) {
        // if we run out of p, then match is over. But if only s is exhausted, match may continue
        if (n == p.length) return m == s.length;
        
        if (!(n+1 < p.length && p[n+1] == '*')) { // p[n+1] != '*', must match
            if (m < s.length && n < p.length    // look out for bound, actually no need to check n, but m is necessary
                && (s[m] == p[n] || p[n] == '.')) 
                return isMatch(s, p, m+1, n+1);
            else
                return false;
        } else { // p[n+1] is '*'
            while (n+2 < p.length && p[n+2] == p[n]
                    && n+3 < p.length && p[n+3] == '*') n += 2; // skip same 'X*'
            
            if (m >= s.length || !(s[m] == p[n] || p[n] == '.')) // s[m] not match with p[n]. Look out for (m >= s.length) case: <"", ".*">
                return isMatch(s, p, m, n+2);
            else                                                // s[m] match with p[n]
                return isMatch(s, p, m, n+2) 
                    || isMatch(s, p, m+1, n) 
                    || isMatch(s, p, m+1, n+2);
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
