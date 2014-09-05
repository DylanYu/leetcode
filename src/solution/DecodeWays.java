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
}
