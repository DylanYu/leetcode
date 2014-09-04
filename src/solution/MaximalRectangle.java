package solution;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all 
 * ones and return its area.
 * 
 * @author Dongliang Yu
 *
 */
public class MaximalRectangle {
    // use LargestRectangleInHistogram
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                nums[i][j] = matrix[i][j] == '0' ? 0 : 1;
        // build histogram
        for (int j = 0; j < n; j++)
            for (int i = 1; i < m; i++)
                if (nums[i][j] != 0) nums[i][j] += nums[i-1][j];
        int maxArea = 0;
        LargestRectangleInHistogram instance = new LargestRectangleInHistogram();
        // calculate max area row by row
        for (int i = 0; i < m; i++)
            maxArea = Math.max(maxArea, instance.largestRectangleArea(nums[i]));
        return maxArea;
    }
}
