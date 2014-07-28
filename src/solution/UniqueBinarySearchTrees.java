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
        return numTrees(1, n);
    }
    
    // [hi, lo]
    private int numTrees(int lo, int hi) {
        if (lo > hi) return 1; // should be zero, but for this problem we have to set it as 1 for the multiplication below
        if (lo == hi) return 1;
        int sum = 0;
        for (int i = lo; i <= hi; i++)
            sum += (numTrees(lo, i-1) * numTrees(i+1, hi));
        return sum;
    }
    */
}
