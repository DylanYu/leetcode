package solution;

/**
 * A robot is located at the top-left corner of a m x n grid.
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach 
 * the bottom-right corner of the grid.
 *
 * How many possible unique paths are there?
 * 
 * @author Dongliang Yu
 *
 */
public class UniquePaths {
    // iterative DP, memory usage O(m)
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        //if (m == 1 || n == 1) return 1;
        int[] A = new int[m];
        for (int i = 0; i < m; i++) A[i] = 1;
        //int[] B = new int[m];
        for (int j = 1; j < n; j++) {
            //B[0] = 1;
            for (int i = 1; i < m; i++)
                A[i] = A[i] + A[i-1];
            //int[] tmp = A;
            //A = B;
            //B = tmp;
        }
        return A[m-1];
    }
    
    /*
     * iterative DP, memory usage O(m*n)
     * 
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] A = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) A[i][j] = 1;
                else A[i][j] = A[i-1][j] + A[i][j-1];
            }
        }
        return A[m-1][n-1];
    }
    */
    
    /* recursive DP
     * 
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        matrix[0][0] = 1;
        return getPaths(matrix, m-1, n-1);
    }
    
    // DP
    private int getPaths(int[][] matrix, int i, int j) {
        //if(i < 0 || j < 0) return 0;
        if (i == 0 || j == 0) return 1;
        if (matrix[i][j] != 0) return matrix[i][j];
        matrix[i][j] = getPaths(matrix, i-1, j) + getPaths(matrix, i, j-1);
        return matrix[i][j];
    }
    */
}
