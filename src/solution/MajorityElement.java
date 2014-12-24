package solution;

/**
 * Given an array of size n, find the majority element. The majority element 
 * is the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always 
 * exist in the array.
 * 
 * @author Dongliang Yu
 *
 */
public class MajorityElement {
    // Moore's voting algorithm
    // http://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.htm
    public int majorityElement(int[] num) {
        if (num == null || num.length == 0) return 0; // Exception
        int majIdx = 0;
        int count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) majIdx = i;
            if (num[majIdx] == num[i]) count++;
            else count--;
        }
        return num[majIdx];
    }
    
    /**
     * 
    public int majorityElement(int[] num) {
        if (num == null || num.length == 0) return 0; // Exception
        int n = num.length;
        int threshold = n / 2;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int e : num) {
            if (map.containsKey(e))
                map.put(e, map.get(e)+1);
            else
                map.put(e, 1);
            if (map.get(e) > threshold) return e;
        }
        return 0; // Not found
    }
    */
}
