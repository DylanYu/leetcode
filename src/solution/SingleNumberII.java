package solution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Given an array of integers, every element appears three times except for one. 
 * Find that single one.
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it 
 * without using extra memory?
 * 
 * @author Dongliang Yu
 *
 */
public class SingleNumberII {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int e : A) {
                count += (e >> i) & 1;
            }
            result |= (count % 3) << i;
        }
        return result;
    }
    
    public static int singleNumberUseExtraSpace(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int e : A) {
            if (!map.containsKey(e)) map.put(e, 1);
            else {
                int v = map.get(e);
                if (v == 2) map.remove(e);
                else map.put(e, v+1);
            }
        }
        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
}
