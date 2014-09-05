package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, 
 * print the sequence of gray code. A gray code sequence must begin with 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * @author Dongliang Yu
 *
 */
public class GrayCode {
    //  neat solution
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        int idx = 0;
        while (idx < n) {
            int inc = 1 << idx;
            for (int i = ret.size()-1; i >= 0; i--)
                ret.add(ret.get(i) + inc);
            idx++;
        }
        return ret;
    }
    
    /* 
     * straight forward way
     * 
    public List<Integer> grayCode(int n) {
        List<Integer> rst = new ArrayList<Integer>();
        boolean[] arr = new boolean[n];
        rst.add(0);
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(0);
        int total = (int) Math.pow(2, n);
        int count = 1;
        while (count < total) {
            for (int i = n-1; i >= 0; i--) {
                arr[i] = !arr[i];
                int number = getNumber(arr);
                if (set.contains(number)) arr[i] = !arr[i];
                else {
                    set.add(number);
                    rst.add(number);
                    break;
                }
            }
            count++;
        }
        return rst;
    }
    
    private int getNumber(boolean[] arr) {
        int n = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i]) n += Math.pow(2, arr.length-1-i);
        }
        return n;
    }
    */
}
