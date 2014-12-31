package solution;

import java.util.Arrays;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great":
 * 
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * 
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * 
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * 
 * @author Dongliang Yu
 *
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);
        if (!Arrays.equals(c1, c2)) return false;
        int len = s1.length();
        for (int i = 1; i < len; i++) {
            String s1left = s1.substring(0, i);
            String s1right = s1.substring(i);
            String s2left = s2.substring(0, i);
            String s2right = s2.substring(i);
            if (isScramble(s1left, s2left) && isScramble(s1right, s2right)) return true;
            
            s2left = s2.substring(0, len-i);
            s2right = s2.substring(len-i);
            if (isScramble(s1left, s2right) && isScramble(s1right, s2left)) return true;
        }
        return false;
    }
    
    /**
     * DP
     * 
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        int len = s1.length();
        int[][][][] A = new int[len][len][len][len];
        return isScramble(A, s1, 0, len-1, s2, 0, len-1);
    }
    
    // 0-init, 1-true, 2-false
    private boolean isScramble(int[][][][] A, String s1, int a1, int a2, String s2, int b1, int b2) {
        if (A[a1][a2][b1][b2] != 0) return A[a1][a2][b1][b2] == 1;
        A[a1][a2][b1][b2] = 2;
        if (a2-a1 != b2-b1)
            A[a1][a2][b1][b2] = 2;
        else if (s1.substring(a1, a2+1).equals(s2.substring(b1, b2+1)))
            A[a1][a2][b1][b2] = 1;
        else {
            char[] c1 = s1.substring(a1, a2+1).toCharArray();
            Arrays.sort(c1);
            char[] c2 = s2.substring(b1, b2+1).toCharArray();
            Arrays.sort(c2);
            if (!Arrays.equals(c1, c2)) A[a1][a2][b1][b2] = 2;
            else {
                for (int i = 0; i <= a2-a1-1; i++)
                    if (isScramble(A, s1, a1, a1+i, s2, b1, b1+i)
                            && isScramble(A, s1, a1+i+1, a2, s2, b1+i+1, b2)
                        || isScramble(A, s1, a1, a1+i, s2, b2-i, b2)
                            && isScramble(A, s1, a1+i+1, a2, s2, b1, b2-i-1)) {
                        A[a1][a2][b1][b2] = 1;
                        break;
                    }
            }
        }
        return A[a1][a2][b1][b2] == 1;
    }
    */
    
    public static void main(String[] args) {
        //String s1 = "abcdefghij"; // false
        //String s2 = "efghijcadb";
        //String s1 = "abc"; // true
        //String s2 = "cba";
        String s1 = "ccbbcaccbccbbbcca"; // false
        String s2 = "ccbbcbbaabcccbccc";
        System.out.println(new ScrambleString().isScramble(s1, s2));
    }
}
