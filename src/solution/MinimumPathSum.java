package solution;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to 
 * bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 * 
 * @author Dongliang Yu
 *
 */
public class MinimumPathSum {
    // more advanced O(n) extra space solution;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return Integer.MAX_VALUE;
        int n = grid[0].length;
        if (n == 0) return Integer.MAX_VALUE;
        int[] A = new int[n+1];
        for (int i = 0; i <=n; i++) A[i] = Integer.MAX_VALUE;
        A[1] = 0; // important
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                A[j] = grid[i-1][j-1] + Math.min(A[j-1], A[j]);
        return A[n];
    }
    
    /*
     * different start direction
     * 
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return Integer.MAX_VALUE;
        int n = grid[0].length;
        if (n == 0) return Integer.MAX_VALUE;
        int[] A = new int[m+1];
        for (int i = 0; i <= m; i++) A[i] = Integer.MAX_VALUE;
        A[1] = 0; // important
        for (int j = 0; j < n; j++)
            for (int i = 0; i < m; i++)
                A[i+1] = grid[i][j] + Math.min(A[i], A[i+1]);
        return A[m];
    }
    */
    
    /*
     * example shows that we should take care of initial state 
     *
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return Integer.MAX_VALUE;
        int n = grid[0].length;
        if (n == 0) return Integer.MAX_VALUE;
        int[][] A = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) A[i][0] = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) A[0][i] = Integer.MAX_VALUE;
        A[1][0] = 0; // or A[0][1] = 0, just need one 0 to give the Math.min a chance
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                A[i][j] = grid[i-1][j-1] + Math.min(A[i-1][j], A[i][j-1]);
        return A[m][n];
    }
    */
    
    /*
     * straight forward O(n) extra space solution
     * 
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] A = new int[m];
        for (int i = 0; i < m; i++)
            A[i] = grid[i][n-1];
        for (int i = m-2; i >= 0; i--)
            A[i] += A[i+1];

        for (int j = n-2; j >= 0; j--) {
            int[] cur = new int[m];
            cur[m-1] = A[m-1] + grid[m-1][j];
            for (int i = m-2; i >= 0; i--)
                cur[i] = Math.min(cur[i+1], A[i]) + grid[i][j];
            A = cur;
        }
        return A[0];
    }
    */
    
    /**
     * recursive DP
     *  
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                sum[i][j] = -1; // assign to -1 not 0 because of 'non-negative'
        sum[m-1][n-1] = grid[m-1][n-1];
        return getPathSum(sum, grid, 0, 0);
    }
    
    private int getPathSum(int[][] sum, int[][] grid, int x, int y) {
        if (x >= sum.length || y >= sum[0].length) return Integer.MAX_VALUE;
        if (sum[x][y] != -1) return sum[x][y];
        sum[x][y] = Math.min(getPathSum(sum, grid, x+1, y), getPathSum(sum, grid, x, y+1)) + grid[x][y];
        return sum[x][y];
    }
    */
}
