package solution;

public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        StringBuffer sb = new StringBuffer(p);
        int len = sb.length();
        int i = 0;
        while (i < len) {
            if (sb.charAt(i) == '*' && i < len-1 && sb.charAt(i+1) == '*') {
                sb.deleteCharAt(i);
                len--;
            }
            else
                i++;
        }
        return match(s, sb.toString());
    }
    
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
    }

    public static void main(String[] args) {
        String s = "abbbaaaaaaaabbbabaaabbabbbaabaabbbbaabaabbabaabbabbaabbbaabaabbabaabaabbbbaabbbaabaaababbbbabaaababbaaa";
        String p = "ab**b*bb*ab**ab***b*abaa**b*a*aaa**bba*aa*a*abb*a*a";
        System.out.println(isMatch(s, p));
    }
}
