package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 
 * @author Dongliang Yu
 *
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        // pay attention to generic problem
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            if (i >= 2) {
                List<Integer> lastRow = result.get(i-1);
                for (int j = 1; j < i; j++)
                    row.add(lastRow.get(j-1) + lastRow.get(j));
            }
            if (i != 0) row.add(1);
            result.add(row);
        }
        return result;
    }
}
