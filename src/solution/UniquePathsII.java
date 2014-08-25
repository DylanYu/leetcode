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
}
