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
        if (n < 0) return null; // n==0 is OK
        int[][] M = new int[n][n];
        int num = 1;
        int lo = 0;
        int hi = n-1;
        while (lo <= hi) {
            int x = lo;
            int y = lo;
            while (y < hi) M[x][y++] = num++;
            while (x < hi) M[x++][y] = num++;
            if (x == lo) { M[x][y] = num; break; } // one block left case
            while (y > lo) M[x][y--] = num++;
            while (x > lo) M[x--][y] = num++;
            lo++;
            hi--;
        }
        //if (lo == hi) matrix[lo][lo] = number; // odd case, not necessary for even case
        return M;
    }
}
