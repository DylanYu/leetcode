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
    // iterative DP
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) return false;
        //if (len3 == 0) return len1 == 0 && len2 == 0;
        //if (len1 == 0) return s2.equals(s3);
        //if (len2 == 0) return s1.equals(s3);
        
        boolean[][] A = new boolean[len1+1][len2+1]; // A[i][j] == true means s1[0,i) and s2[0,j) can form s3[0,i+j)
        // init
        for (int i = 1; i <= Math.min(len2, len3); i++)
            if (s2.charAt(i-1) == s3.charAt(i-1)) A[0][i] = true;
            else break;
        for (int i = 1; i <= Math.min(len1, len3); i++)
            if (s1.charAt(i-1) == s3.charAt(i-1)) A[i][0] = true;
            else break;
        A[0][0] = true; // "" + "" = "" 
        
        for (int i = 1; i <= len1; i++) {
            char c1 = s1.charAt(i-1);
            for (int j = 1; j <= len2; j++) {
                char c2 = s2.charAt(j-1);
                char c3 = s3.charAt(i+j-1);
                if (c1 != c3 && c2 != c3) A[i][j] = false;
                else if (c1 == c3 && c2 != c3) A[i][j] = A[i-1][j];
                else if (c1 != c3 && c2 == c3) A[i][j] = A[i][j-1];
                else A[i][j] = A[i-1][j] || A[i][j-1];
            }
        }
        return A[len1][len2];
    }
    
    /**
     * recursive DP, uses more space than non-recursive approach, we have to use Int to 
     * store temporary result because we need a 'init state' rather than just true or false
     * 
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) return false;
        //if (len3 == 0) return len1 == 0 && len2 == 0;
        //if (len1 == 0) return s2.equals(s3);
        //if (len2 == 0) return s1.equals(s3);
        
        int[][] A = new int[len1+1][len2+1]; // A[i][j] == 1 means s1[0,i) and s2[0,j) can form s3[0,i+j)
        // init
        for (int i = 0; i <= len1; i++)
            for (int j = 0; j <= len2; j++)
                A[i][j] = -1;
        for (int i = 1; i <= Math.min(len2, len3); i++)
            if (s2.charAt(i-1) == s3.charAt(i-1)) A[0][i] = 1;
            else while (i <= Math.min(len2, len3)) A[0][i++] = 0;
        for (int i = 1; i <= Math.min(len1, len3); i++)
            if (s1.charAt(i-1) == s3.charAt(i-1)) A[i][0] = 1;
            else while (i <= Math.min(len1, len3)) A[i++][0] = 0;
        A[0][0] = 1; // "" + "" = "" 
        
        return DP(A, s1, s2, s3, len1, len2) == 1;
    }
    
    private int DP(int[][] A, String s1, String s2, String s3, int i, int j) {
        if (A[i][j] != -1) return A[i][j];
        char c1 = s1.charAt(i-1);
        char c2 = s2.charAt(j-1);
        char c3 = s3.charAt(i+j-1);
        if (c1 != c3 && c2 != c3) A[i][j] = 0;
        else if (c1 == c3 && c2 != c3)
            A[i][j] = DP(A, s1, s2, s3, i-1, j);
        else if (c1 != c3 && c2 == c3)
            A[i][j] = DP(A, s1, s2, s3, i, j-1);
        else
            if (DP(A, s1, s2, s3, i-1, j) == 1 || DP(A, s1, s2, s3, i, j-1) == 1)
                A[i][j] = 1;
            else
                A[i][j] = 0;
        return A[i][j];
    }
    */
    
    /*
     * DFS, will TLE
     * 
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) return false;
        if (len3 == 0) return len1 == 0 && len2 == 0;
        if (len1 == 0) return s2.equals(s3);
        if (len2 == 0) return s1.equals(s3);
        char c1 = s1.charAt(len1-1);
        char c2 = s2.charAt(len2-1);
        char c3 = s3.charAt(len3-1);
        if (c1 != c3 && c2 != c3) return false;
        if (c1 == c3 && c2 != c3)
            return isInterleave(s1.substring(0, len1-1), s2, s3.substring(0, len3-1));
        if (c1 != c3 && c2 == c3)
            return isInterleave(s1, s2.substring(0, len2-1), s3.substring(0, len3-1));
        return isInterleave(s1.substring(0, len1-1), s2, s3.substring(0, len3-1))
                || isInterleave(s1, s2.substring(0, len2-1), s3.substring(0, len3-1));
    }
    */
    
    /*
     * BFS, will TLE,
     * each time we just move one step forward, much slower than DFS (recursive way)
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
