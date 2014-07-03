package solution;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * <p>Note:
 * <p>Your algorithm should have a linear runtime complexity. Could you implement it without 
 * using extra memory?
 *
 * @author Dongliang Yu
 *
 */
public class SingleNumber {
    /**
     * Awesome solution 
     */
    public static int singleNumber(int[] A) {
        int single = 0;
        for(int e : A)
            single ^= e;
        return single;
    }
    
    public static int singleNumberUseExtraSpace(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int e : A) {
            if (set.contains(e)) set.remove(e);
            else set.add(e);
        }
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
}
