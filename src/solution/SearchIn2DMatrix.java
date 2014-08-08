package solution;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 *
 * Consider the following matrix:
 * 
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * 
 * @author Dongliang Yu
 *
 */
public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = getRow(matrix, target);
        if (row < 0) return false;
        int col = getCol(matrix, row, target);
        if (col < 0) return false;
        else return true;
    }
    
    private int getRow(int[][] matrix, int target) {
        return getRow(matrix, 0, matrix.length-1, target);
    }
    
    private int getRow(int[][] matrix, int lo, int hi, int target) {
        if (lo >= hi) {
            if (target < matrix[lo][0]) return lo-1; // may return -1, it's what we need
            else return lo;
        }
        int mid = lo + (hi - lo) / 2;
        if (matrix[mid][0] < target) return getRow(matrix, mid+1, hi, target);
        else if (matrix[mid][0] > target) return getRow(matrix, lo, mid-1, target);
        else return mid;
    }
    
    private int getCol(int[][] matrix, int row, int target) {
        return getCol(matrix, 0, matrix[0].length-1, row, target);
    }
    
    private int getCol(int[][] matrix, int lo, int hi, int row, int target) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (matrix[row][mid] < target) return getCol(matrix, mid+1, hi, row, target);
        else if (matrix[row][mid] > target) return getCol(matrix, lo, mid-1, row, target);
        else return mid;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1}, {3}};
        //int[][] matrix = {{1}, {3}, {5}};
        //int[][] matrix = {
        //        {1,3,5,7},
        //        {10,11,16,20},
        //        {23,30,34,50}
        //};
        System.out.println(new SearchIn2DMatrix().searchMatrix(matrix, 0));
    }
}
