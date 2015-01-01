package solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    
    /*
     * just swap, no any extra space approach
     * 
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int x0 = 0;
        int y0 = 0;
        int x1 = n-1;
        int y1 = n-1;
        while (x0 < x1) {
            // 1234 => 4123 needs three swaps (1&4, 1&3, 1&2)
            for (int i = 1; y0+i <= y1; i++) // 1 & 4
                swap(matrix, x0, y0+i, x1-i, y0);
            for (int i = 1; y1-i >= y0; i++) // 1(4) & 3
                swap(matrix, x1, y1-i, x1-i, y0);
            for (int i = 1; y1-i >= y0; i++)// 1(3) & 2
                swap(matrix, x1, y1-i, x0+i, y1);
            x0++;
            y0++;
            x1--;
            y1--;
        }
    }
    */
    
    /*
     * Magic solution:
     * 1) flip (not rotate) the matrix upside down. (reverse)
     * 2) flip again, but this time bottom edge to the right. (swap)
     * 
     * Caution:
     * Arrays.asList and list.toArray will not create new array, 
     * so all the operations are implemented on the original matrix.
     * 
    public void rotate(int[][] matrix) {
        List<int[]> list = Arrays.asList(matrix);
        Collections.reverse(list);
        matrix = (int[][]) list.toArray();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                swap(i, j, j, i);
            }
        }
    }
    */
    
    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        if (i1 == i2 && j1 == j2) return; // required
        matrix[i1][j1] += matrix[i2][j2];
        matrix[i2][j2] = matrix[i1][j1] - matrix[i2][j2];
        matrix[i1][j1] -= matrix[i2][j2];
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
