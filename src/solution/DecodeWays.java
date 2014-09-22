package solution;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * @author Dongliang Yu
 *
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] A = new int[s.length()+1];
        A[0] = 1;
        //A[1] = s.charAt(0) == '0' ? 0 : 1; // handled by later logic
        char prev = ' ';
        for (int i = 1; i < A.length; i++) {
            char curr = s.charAt(i-1);
            if (curr == '0') {
                if (prev != '1' && prev != '2') return 0; // wrong format
                else A[i] = A[i-2];
            } else {
                A[i] = A[i-1];
                if (prev == '1' || (prev == '2' && curr <= '6'))
                    A[i] += A[i-2];
            }
            prev = curr;
        }
        return A[A.length-1];
    }
    
    /*
     * naive way, too slow
     *
    private int count;
    
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        count = 0;
        decode(s.toCharArray(), 0);
        return count;
    }
    
    private void decode(char[] c, int idx) {
        if (idx >= c.length) {
            count++;
            return;
        }
        char curr = c[idx];
        if ('1' <= curr && curr <= '9')
            decode(c, idx+1);
        if (idx+1 < c.length) {
            char next = c[idx+1];
            if (curr == '1' && '0' <= next && next <= '9'
                || curr == '2' && '0' <= next && next <= '6')
                decode(c, idx+2);
        }
    }
    */
    
    public static void main(String[] args) {
        int num = new DecodeWays().numDecodings("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565");
        System.out.println(num);
    }
}
