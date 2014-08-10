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
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        matrix[m-1][n-1] = 1;
        return getPaths(matrix, 0, 0);
    }
    
    // DP
    private int getPaths(int[][] matrix, int m, int n) {
        if (m >= matrix.length || n >= matrix[0].length) return 0;
        if (matrix[m][n] != 0) return matrix[m][n];
        matrix[m][n] = getPaths(matrix, m+1, n) + getPaths(matrix, m, n+1);
        return matrix[m][n];
    }
}
