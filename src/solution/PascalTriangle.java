package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

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
        LinkedList<List<Integer>> ret = new LinkedList<List<Integer>>(); // use LinkedList to obtain method getlast()
        if (numRows <= 0) return ret;
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);
        ret.add(row);
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> lastRow = (ArrayList<Integer>) ret.getLast();
            ArrayList<Integer> currRow = new ArrayList<Integer>(lastRow.size()+1);
            currRow.add(1); // do not use set here, index out of bounds
            for (int j = 1; j < lastRow.size(); j++) // do not use currRow.size() here, size is not capacity
                currRow.add(lastRow.get(j-1)+lastRow.get(j));
            currRow.add(1);
            ret.add(currRow);
        }
        return ret;
    }
}
