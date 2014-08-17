package solution;

import java.util.Stack;

public class WildcardMatching {
    // when not match, if there's previous star, try to use it to suck more characters
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int stari = -1;
        int starj = -1;
        char[] S = s.toCharArray();
        char[] P = p.toCharArray();
        int len1 = S.length;
        int len2 = P.length;
        boolean star = false;
        while (i < len1) {
            if (j < len2 && (S[i] == P[j] || P[j] == '?')) {
                i++;
                j++;
            } else if (j < len2 && P[j] == '*') {
                star = true;
                while (j < len2) {
                    if (P[j] != '*') break;
                    j++;
                }
                if (j == len2) return true; // ends with *, match everything
                stari = i+1; // suck this character in matched items
                starj = j-1;
            } else  { // no match or regex is exhausted (j >= len2 && i < len1) , try to restore from previous *
                if (!star) {
                    return false; // no previous star to try
                } else {
                    i = stari;
                    j = starj;
                    //star = false; // not necessary
                }
            }
        }
        while (j < len2 && P[j] == '*') j++;
        return j == len2;
    }
    
    /*
    public static boolean isMatch(String s, String p) {
        StringBuffer sb = new StringBuffer(p);
        int len = sb.length();
        for (int i = 1; i < len; i++)
            if (sb.charAt(i) == '*' && sb.charAt(i-1) == '*') {
                sb.deleteCharAt(i);
                len--;
            }
        return match(s, sb.toString());
    }
    
    private static boolean noMatch(String s, String p, int i, int j, Stack<Integer> starIndex) {
        int len1 = s.length();
        int len2 = p.length();
        if (i >= len1 || j >= len2) {
            return true;
        } else {
            int len1Left = len1 - i;
            int len2Left = p.substring(j).replace("*", "").length();
            if (len1Left < len2Left)
                return true;
            char chp =p.charAt(j);
            if (chp == '*' || chp == '?') {
                return false;
            } else {
                char chs = s.charAt(i);
                if (chs != chp) return true;
                else return false;
            }
        }
    }

    private static boolean match(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        // tail not match
        if (len1 > 0 && len2 > 0 && p.charAt(len2-1) != '*') {
            for (int i = len1-1, j = len2-1; i > 0 && j > 0; i--, j--) {
                char chs = s.charAt(i);
                char chp = p.charAt(j);
                if (chs == chp || chp == '?') continue;
                else if (chp == '*') break;
                else return false;
            }
        }
        int i = 0;
        int j = 0;
        Stack<Integer> starMatchIndex = new Stack<Integer>();
        Stack<Integer> starIndex = new Stack<Integer>();
        while (true) {
            if (i == len1 && j == len2)
                return true;
            boolean noMatch = noMatch(s, p, i, j, starIndex);
            if (noMatch && starIndex.empty())
                return false;
            
            if (noMatch) {
                i = starMatchIndex.pop() + 1;
                j = starIndex.pop();
                continue;
            }
            // else
            char chs = s.charAt(i);
            char chp = p.charAt(j);
            if (chp == '*') {
                starMatchIndex.push(i);
                starIndex.push(j);
                i++;
                j++;
                continue;
            } else if (chs == chp || chp == '?') {
                i++;
                j++;
                continue;
            } else { // back
                System.out.println("Not Possible");
                i = starMatchIndex.pop() + 1;
                j = starIndex.pop();
                continue;
            }
        }
    }
    */
    
    /*
     * recursive way, not efficient for large input
    private static boolean match(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        // check empty string cases
        if (lenS == 0) {
            if (lenP == 0) return true;
            else { // s is empty, p must be "*" TODO test
                if (p.equals("*")) return true;
                else return false;
            }
        } else {
            if (lenP == 0) return false;
        }
        // check tail
        char pTail = p.charAt(p.length()-1);
        if (pTail != '*') {
            char sTail = s.charAt(s.length()-1);
            if (pTail != sTail) return false;
        }
        // TOO SLOW
        //String tmp = p.replace("*", "");
        //int lenPNoStar = tmp.length();
        //if (lenPNoStar > lenS) return false;
        int lenPNoStar = 0;
        for (int i = 0; i < lenP; i++)
            if (p.charAt(i) != '*') lenPNoStar++;
        if (lenPNoStar > lenS) return false;
        
        char a = s.charAt(0);
        char b = p.charAt(0);
        if (b != '?' && b != '*') {
            if (a != b) return false;
            else return match(s.substring(1), p.substring(1));
        } else if (b == '?'){
            return match(s.substring(1), p.substring(1));
        } else { // b == '*'
            return match(s.substring(1), p.substring(1)) 
                    || match(s.substring(1), p);
        }
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
