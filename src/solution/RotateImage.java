package solution;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 * Could you do this in-place?
 * 
 * @author Dongliang Yu
 *
 */
public class RotateImage {
    // in-place solution
    public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int level = 0; level < n/2; level++) {
        for (int i = level; i < n-1-level; i++) {
            int tmp = matrix[n-1-i][level];
            matrix[n-1-i][level] = matrix[n-1-level][n-1-i];
            matrix[n-1-level][n-1-i] = matrix[i][n-1-level];
            matrix[i][n-1-level] = matrix[level][i];
            matrix[level][i] = tmp;
        }
    }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1,2},{3,4}};
        new RotateImage().rotate(matrix);
        for (int[] row : matrix) {
            for(int e : row)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}
