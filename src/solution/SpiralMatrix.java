package solution;

import java.util.List;
import java.util.LinkedList;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * For example,
 * Given the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * @author helo
 *
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new LinkedList<Integer>();
        if (matrix == null) return ret;
        int m = matrix.length;
        if (m == 0) return ret; // keep attention..
        int n = matrix[0].length;
        //if (n == 0) return ret;
        int x0 = 0; // most left up point
        int y0 = 0;
        int x1 = m-1; // most right bottom point
        int y1 = n-1;
        //while(x0 < x1 && y0 < y1) {
        while(x0 <= x1 && y0 <= y1) {
            int x = x0; // after one loop, (x, y) goes back to original position, must set them 'forward'
            int y = y0;
            // traverse around
            while (y < y1) ret.add(matrix[x][y++]);
            while (x < x1) ret.add(matrix[x++][y]);
            // one row or col or one block left case
            if (x == x0 || y == y0) { ret.add(matrix[x][y]); break; }
            while (y > y0) ret.add(matrix[x][y--]);
            while (x > x0) ret.add(matrix[x--][y]);
            x0++;
            y0++;
            x1--;
            y1--;
        }
        /*
        x = x0; // set 'forward'
        y = y0;
        if (x0 == x1 && y0 <= y1) {
            while (y <= y1) list.add(matrix[x][y++]);
        } else if (y0 == y1 && x0 <= x1) { // use 'else' to keep away from 'counting twice when x0==x1 && y0==y1' case
            while (x <= x1) list.add(matrix[x++][y]);
        }
        */
        return ret;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        List<Integer> list = new SpiralMatrix().spiralOrder(matrix);
        for (int e : list)
            System.out.print(e + " ");
    }
}
