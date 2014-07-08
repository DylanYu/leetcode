package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * @author Dongliang Yu
 *
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = list.size()-1; j >= 1; j--)
                list.set(j, list.get(j) + list.get(j-1));
            list.add(1);
        }
        return list;
    }
}
