package solution;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to 
 * adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * @author Dongliang Yu
 *
 */
public class Triangle {
    // DP with bottom-up way
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.get(triangle.size()-1).size();
        int[] path = new int[len];
        for (int i = 0; i < len; i++)
            path[i] = triangle.get(triangle.size()-1).get(i);
        for (int i = triangle.size()-2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                path[j] = Math.min(path[j], path[j+1]) + row.get(j); // from front to end to avoid poisoning data
            }
        }
        return path[0];
    }
    
    /**
     * O(n) extra space, top-down DP
     * 
     *
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] A = new int[len+1];
        for (int i = 0; i <= len; i++) A[i] = Integer.MAX_VALUE;
        A[1] = 0; // necessary to proceed first iteration
        for (List<Integer> row : triangle) {
            for (int i = row.size(); i >= 1; i--)
                A[i] = Math.min(A[i-1], A[i]) + row.get(i-1); // from back to front to avoid poisoning data
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++)
            min = Math.min(min, A[i]);
        return min;
    }
    */
    
    /*
    // This solution uses a top-down way, but the bottom-up way will be more efficient
    // for no ArrayList recreation.
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            if (path.size() == 0) { // first row
                path.add(row.get(0));
                continue;
            }
            ArrayList<Integer> nextPath = new ArrayList<Integer>();
            for (int j = 0; j < row.size(); j++) {
                int p1;
                int p2;
                int cur = row.get(j);
                if (j == 0) {
                    p2 = path.get(j) + cur;
                    p1 = p2;
                } else if (j == row.size()-1) {
                    p1 = path.get(j-1) + cur;
                    p2 = p1;
                } else {
                    p1 = path.get(j-1) + cur;
                    p2 = path.get(j) + cur;
                }
                nextPath.add(Math.min(p1, p2));
            }
            path = nextPath;
        }
        int min = Integer.MAX_VALUE;
        for (int e : path)
            if (e < min) min = e;
        return min;
    }
    */
}
