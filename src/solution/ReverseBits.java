package solution;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 *
 * Follow up:
 * If this function is called many times, how would you optimize it?
 *
 * @author Dongliang Yu
 *
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret |= ((n & 1) << (31 - i));
            n >>= 1;
        }
        return ret;
    }
    
    /**
    public int reverseBits(int n) {
        int i = 31;
        int j = 0;
        while (i > j)
            n = swap(n, i--, j++);
        return n;
    }
    
    private int swap(int n, int i, int j) {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;
        if (a == b) return n;
        if (a == 0) {
            n |= (1 << i);
            n &= (~(1 << j));
        } else {
            n &= (~(1 << i));
            n |= (1 << j);
        }
        return n;
    }
    */
}
