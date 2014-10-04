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
        int maxArea = 0;
        int[] height = new int[n];
        LargestRectangleInHistogram instance = new LargestRectangleInHistogram();
        for (int i = 0; i < m; i++) {
            char[] row = matrix[i];
            for (int j = 0; j < n; j++)
                if (row[j] == '0') height[j] = 0;
                else height[j]++;
            int localMax = instance.largestRectangleArea(height);
            maxArea = Math.max(maxArea, localMax);
        }
        return maxArea;
    }
}
