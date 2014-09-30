package solution;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 * @author Dongliang Yu
 *
 */
public class SetMatrixZeros {
    // O(1) extra space
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isLeftColZero = false;
        boolean isUpRowZero = false;
        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0) {
                isLeftColZero = true;
                break;
            }
        for (int j = 0; j < n; j++)
            if (matrix[0][j] ==  0) {
                isUpRowZero = true;
                break;
            }
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        for (int i = 1; i < m; i++)
            if (matrix[i][0] == 0)
                for (int j = 0; j < n; j++)
                    matrix[i][j] = 0;
        for (int j = 1; j < n; j++)
            if (matrix[0][j] == 0)
                for (int i = 0; i < m; i++)
                    matrix[i][j] = 0;
        if (isLeftColZero)
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        if (isUpRowZero)
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
    }

    /* O(m+n) extra space
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        if (n == 0) return;
        Set<Integer> xset = new HashSet<Integer>();
        Set<Integer> yset = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    xset.add(i);
                    yset.add(j);
                }
            }
        }
        for (int x : xset)
            for (int y = 0; y < n; y++) matrix[x][y] = 0;
        for (int y : yset)
            for (int x = 0; x < m; x++) matrix[x][y] = 0;
    }
    */
}
