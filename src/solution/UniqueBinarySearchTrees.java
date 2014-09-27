package solution;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 * 
 * @author Dongliang Yu
 *
 */
public class UniqueBinarySearchTrees {
    // recursive DP
    public int numTrees(int n) {
        int[] T = new int[n];   // use values 0..n-1 (same as 1..n)
                                // T[i] means number of trees derived by keys range [0, i-1]
        return numTreesHelper(T, n-1);
    }
    
    private int numTreesHelper(int[] T, int n) {
        if (n == -1) return 1; // no left (or right) subtree case
        if (T[n] != 0) return T[n];
        for (int i = 0; i <= n; i++) // 
            // T[n-1-i] equals number of trees derived from keys of [i+1, n]
            T[n] += numTreesHelper(T, i-1) * numTreesHelper(T, n-1-i);
        return T[n];
    }
    
    /* non-recursive DP
    public int numTrees(int n) {
        int[] T = new int[n+1]; // use values 1..n
        T[0] = 1; // no left (or right) subtree case
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++) // choose root from [1, i]
                T[i] += T[j-1] * T[i-j];
        return T[n];
    }
    */
    
    /* straight forward way
    public int numTrees(int n) {
        int[][] A = new int[n][n];
        return numTrees(A, 0, n-1);
    }
    
    private int numTrees(int[][] A, int i, int j) {
        if (i > j) return 1; // should be 0, but return 1 for the multiplication
        if (A[i][j] != 0) return A[i][j];
        if (i == j) A[i][j] = 1;
        else {
            for (int k = i; k <= j; k++)
                A[i][j] += numTrees(A, i, k-1) * numTrees(A, k+1, j); // * not +
        }
        return A[i][j];
    }
    */
}
