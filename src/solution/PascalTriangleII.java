package solution;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        if (rowIndex == 0) return list1;
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 1; j < list1.size(); j++)
                list2.set(j, list1.get(j-1) + list1.get(j));
            list2.add(1);
            ArrayList<Integer> tmp = list2;
            list2 = list1;
            list1 = tmp;
            list2.add(-1); // keep same length as list1
        }
        return list1;
    }
}
