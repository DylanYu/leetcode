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
        int row = searchVertical(matrix, target);
        if (row < 0) return false;
        int col = searchHorizontal(matrix[row], target);
        if (col < 0) return false;
        else return true;
    }
    
    private int searchHorizontal(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (arr[mid] < target) lo = mid+1;
            else if (arr[mid] > target) hi = mid-1;
            else return mid;
        }
        return -1;
    }
    
    private int searchVertical(int[][] matrix, int target) {
        int lo = 0;
        int hi = matrix.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (matrix[mid][0] < target) lo = mid+1;
            else if (matrix[mid][0] > target) hi = mid-1;
            else return mid;
        }
        return hi;
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
