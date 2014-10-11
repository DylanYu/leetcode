package solution;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting 
 * some (can be none) of the characters without disturbing the relative positions of the remaining 
 * characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * 
 * @author Dongliang Yu
 *
 */
public class DistinctSubsequences {
    // non-recursive DP solution, O(m * n) running time and O(m * n) extra space.
    // index processing is tricky
    public int numDistinct(String S, String T) {
        if (S == null || T == null || T.length() > S.length()) return 0;
        int lenS = S.length();
        int lenT = T.length();
        int[][] A = new int[lenS+1][lenT+1]; // [0][j] means S is "", [i][0] means T is ""
        for (int i = 0; i <= lenS; i++)
            A[i][0] = 1;            // T is "", any start of S could be counted as a subsequence, even S is ""
        for (int i = 1; i <= lenS; i++)
            for (int j = 1; j <= lenT; j++)
                A[i][j] = A[i-1][j] 
                        + (S.charAt(i-1) == T.charAt(j-1) ? A[i-1][j-1] : 0); // NOTE: always wrap () for ?
        return A[lenS][lenT];
    }
    
    /**
     * recursive DP solution
     * 
    public int numDistinct(String S, String T) {
        if (S == null || T == null || T.length() > S.length()) return 0;
        int lenS = S.length();
        int lenT = T.length();
        int[][] A = new int[lenS+1][lenT+1]; // [0][j] and [i][0] means empty string S or T case
        for (int i = 1; i <= lenS; i++)
            for (int j = 1; j <= lenT; j++)
                A[i][j] = -1;
        for (int i = 1; i <= lenT; i++) // j start from index 1
            A[0][i] = 0;                // S is "", no subsequence, so number should be 0, except that T is also ""
        for (int i = 0; i <= lenS; i++)
            A[i][0] = 1;                // T is "", any start of S could match an 'empty' subsequence, even S is ""
        // A[0][0] = 1; // T and S are "", one subsequence, already processed before
        return numDistinct(A, S.toCharArray(), T.toCharArray(), lenS, lenT);
    }
    
    private int numDistinct(int[][] A, char[] S, char[] T, int i, int j) {
        if (A[i][j] != -1) return A[i][j];
        A[i][j] = numDistinct(A, S, T, i-1, j) 
                    + (S[i-1] == T[j-1] ? numDistinct(A, S, T, i-1, j-1) : 0); // S[i-1] means String S.charAt(i)
        return A[i][j];
    }
    */
    
    /*
     * O(n) space DP solution
     * 
    public int numDistinct(String S, String T) {
        if (S == null || T == null || T.length() > S.length()) return 0;
        int lenS = S.length();
        int lenT = T.length();
        int[] A = new int[lenT+1];
        A[0] = 1;
        for (int i = 1; i <= lenS; i++)
            for (int j = lenT; j >= 1; j--) // must start from tail to head to avoid breaking data
                A[j] = A[j] + (S.charAt(i-1) == T.charAt(j-1) ? A[j-1] : 0);
        return A[lenT];
    }
    */
    
    /*
     * BF, too slow
     * 
    private int count;
    
    public int numDistinct(String S, String T) {
        if (S == null || T == null || T.length() > S.length()) return 0;
        count = 0;
        recurse(S.toCharArray(), T.toCharArray(), 0, 0);
        return count;
    }
    
    private void recurse(char[] S, char[] T, int xs, int xt) {
        if (xt == T.length) {
            count++;
            return;
        }
        if (xs >= S.length) return;
        if (S.length - xs < T.length - xt) return;
        if (S[xs] == T[xt]) recurse(S, T, xs+1, xt+1);
        recurse(S, T, xs+1, xt);
    }
    */
    
    public static void main(String[] args) {
        //String S = "ccc";
        //String T = "c";
        String S = "rabbbit";
        String T = "rabbit";
        //String S = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
        //String T = "bcddceeeebecbc";
        System.out.println(new DistinctSubsequences().numDistinct(S, T));
    }
}
