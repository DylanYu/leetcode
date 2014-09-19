package solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 * @author Dongliang Yu
 *
 */
public class InterleavingString {
    // DP
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != len1+len2) return false;
        //if (len1 == 0 && len2 == 0 && len3 == 0) return true;
        
        // init
        boolean[][] DP = new boolean[len1+1][len2+1];
        DP[0][0] = true; // s1 is "", s2 is "" and s3 is ""
        for (int i = 1; i <= len1; i++)
            if (s1.charAt(i-1) == s3.charAt(i-1)) DP[i][0] = true;
            else while (i <= len1) DP[i++][0] = false;
        for (int i = 1; i <= len2; i++)
            if (s2.charAt(i-1) == s3.charAt(i-1)) DP[0][i] = true;
            else while (i <= len2) DP[0][i++] = false;
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                boolean ret = false;
                if (s1.charAt(i-1) == s3.charAt(i+j-1))
                    ret |= DP[i-1][j];
                if (s2.charAt(j-1) == s3.charAt(i+j-1))
                    ret |= DP[i][j-1];
               DP[i][j] = ret;
            }
        }
        return DP[len1][len2];
    }
    
    /*
     * DP using HashMap for caching
     * 
    class Pair {
        String a;
        String b;
        String c;
        int hashcode = 0;
        Pair(String x, String y, String z) { a = x; b = y; c = z; }
        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Pair)) return false;
            Pair that = (Pair) obj;
            return this.a.equals(that.a) && this.b .equals(that.b) && this.c.equals(that.c);
        }
        @Override
        public int hashCode() {
            if (hashcode != 0) return hashcode;
            int ret = 17;
            ret += ret * 31 + a.hashCode();
            ret += ret * 31 + b.hashCode();
            ret += ret * 31 + c.hashCode();
            this.hashcode = ret;
            return ret;
        }
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != len1+len2) return false;
        Map<Pair, Boolean> map = new HashMap<Pair, Boolean>();
        return isInterleave(new Pair(s1, s2, s3), map);
    }
    
    public boolean isInterleave(Pair pair, Map<Pair, Boolean> map) {
        if (map.containsKey(pair)) return map.get(pair);
        String a = pair.a;
        String b = pair.b;
        String c = pair.c;
        if (a.length() == 0) {
            if (b.equals(c)) {
                map.put(pair, true);
                return true;
            } else {
                map.put(pair, false);
                return false;
            }
        }
        if (b.length() == 0) {
            if (a.equals(c)) {
                map.put(pair, true);
                return true;
            } else {
                map.put(pair, false);
                return false;
            }
        }
        if (a.charAt(0) == c.charAt(0))
            if (isInterleave(new Pair(a.substring(1), b, c.substring(1)), map)) {
                map.put(pair, true);
                return true;
            }
        if (b.charAt(0) == c.charAt(0))
            if (isInterleave(new Pair(a, b.substring(1), c.substring(1)), map)) {
                map.put(pair, true);
                return true;
            }
        map.put(pair, false);
        return false;
    }
    */
    
    /*
     * DFS
     * 
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != len1+len2) return false;
        return isInterleave(s1, s2, s3, 0, 0, 0);
    }
    
    public boolean isInterleave(String s1, String s2, String s3, int i, int j, int k) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) return true;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
            if (isInterleave(s1, s2, s3, i+1, j, k+1)) return true;
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k))
            if (isInterleave(s1, s2, s3, i, j+1, k+1)) return true;
        return false;
    }
    */
    
    /*
     * BFS, each time we just move one step forward, much slower than DFS (recursive way)
     * 
    class Pair {
        int a;
        int b;
        int c;
        Pair(int i, int j, int k) { a = i; b = j; c = k; }
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != len1+len2) return false;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(0, 0, 0));
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int a = curr.a;
            int b = curr.b;
            int c = curr.c;
            if (a == len1 && b == len2 && c == len3) return true;
            if (a < len1 && s1.charAt(a) == s3.charAt(c)) queue.offer(new Pair(a+1, b, c+1));
            if (b < len2 && s2.charAt(b) == s3.charAt(c)) queue.offer(new Pair(a, b+1, c+1));
        }
        return false;
    }
    */
    
    public static void main(String [] args) {
        //String s1 = "abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb";
        //String s2 = "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc";
        //String s3 = "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc";
        String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
    }
}
