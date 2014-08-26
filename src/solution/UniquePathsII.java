package solution;

/**
 * Follow up for "Unique Paths":
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * 
 * @author Dongliang Yu
 *
 */
public class UniquePathsII {
    // iterative DP, can reduce memory usage to O(m)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] A = new int[m+1][n+1];
        for (int i = 0; i < m; i++)
            A[i][n] = 0;
        for (int i = 0; i < n; i++)
            A[m][i] = 0;
        if (obstacleGrid[m-1][n-1] == 1) return 0;
        A[m-1][n-1] = 1;
        for (int j = n-1; j >= 0; j--) {
            for (int i = m-1; i >= 0; i--) {
                if (j == n-1 && i == m-1) continue;
                if (obstacleGrid[i][j] == 1) A[i][j] = 0;
                else A[i][j] = A[i+1][j] + A[i][j+1];
            }
        }
        return A[0][0];
    }
    
    /*
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] A = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (obstacleGrid[i][j] == 1) A[i][j] = 0; // obstacle
                else A[i][j] = -1; // init status
        if (A[m-1][n-1] != 0) A[m-1][n-1] = 1;
        return getPath(A, 0, 0);
    }
    
    // DP
    private int getPath(int[][] A, int x, int y) {
        if (x >= A.length || y >= A[0].length) return 0;
        if (A[x][y] != -1) return A[x][y];
        A[x][y] = getPath(A, x+1, y) + getPath(A, x, y+1);
        return A[x][y];
    }
    */
}
