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
        //if (rowIndex < 0) return new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        //list.add(1);
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = list.size()-1; j >= 1; j--) // set from tail to head to avoid poisoning data
                list.set(j, list.get(j)+list.get(j-1)); // set not add
            list.add(1);
        }
        return list;
    }
}
