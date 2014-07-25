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
}
