package solution;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example,
 * Given n = 3,
 * 
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 
 * @author Dongliang Yu
 *
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n < 0) return null;
        if (n == 0) return new int[0][]; // only for passing OJ, not necessary exactly, should return null
        int[][] matrix = new int[n][n];
        int number = 1;
        int lo = 0;
        int hi = n-1;
        while (lo < hi) {
            int x = lo;
            int y = lo;
            while (y < hi) matrix[x][y++] = number++;
            while (x < hi) matrix[x++][y] = number++;
            while (y > lo) matrix[x][y--] = number++;
            while (x > lo) matrix[x--][y] = number++;
            lo++;
            hi--;
        }
        if (lo == hi) matrix[lo][lo] = number; // odd case, not necessary for even case
        return matrix;
    }
}
