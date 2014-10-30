package solution;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert 
 * word1 to word2. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *  a) Insert a character
 *  b) Delete a character
 *  c) Replace a character
 * 
 * NOTE: This problem is also called Sequence Alignment
 * 
 * @author Dongliang Yu
 *
 */
public class EditDistance {
    // iterative DP
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return Integer.MAX_VALUE;
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;
        int[][] A = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) A[i][0] = i;
        for (int i = 1; i <= len2; i++) A[0][i] = i;
        //A[0][0] = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int penalty = word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1;
                A[i][j] = Math.min(
                            A[i-1][j-1]  + penalty,
                            Math.min(A[i-1][j] + 1, A[i][j-1] + 1)
                        );
            }
        }
        return A[len1][len2];
   }
    
    /*
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // later logic can handle these cases
        //if (len1 == 0) return len2;
        //if (len2 == 0) return len1;
        int[][] P = new int[len1+1][len2+1];
        for (int i = 0; i < len1+1; i++) // penalty = i * gap
            P[i][0] = i;
        for (int j = 0; j < len2+1; j++) // penalty = j * gap
            P[0][j] = j;
        for (int i = 1; i < len1+1; i++)
            for (int j = 1; j < len2+1; j++)
                P[i][j] = -1;
        return minDistance(P, word1, word2, len1, len2);
    }
    
    // gap means insert or delete, match means exact match or replace
    private int minDistance(int[][] P, String word1, String word2, int i, int j) {
        if (P[i][j] != -1) return P[i][j];
        int penalty = 0;
        if (word1.charAt(i-1) != word2.charAt(j-1)) penalty = 1; // penalty of match or replace
        P[i][j] = Math.min(minDistance(P, word1, word2, i-1, j-1) + penalty, // try to match i,j
            Math.min(minDistance(P, word1, word2, i-1, j) + 1,  // gap in word2
                    minDistance(P, word1, word2, i, j-1) + 1)); // gap in word1
        return P[i][j];
    }
    */
}
