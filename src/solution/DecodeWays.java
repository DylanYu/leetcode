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
    /**
     * 
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        int[] A = new int[s.length()+1];
        A[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] != '0') A[i+1] += A[i];
            if(i-1 >= 0 
                && (arr[i-1] == '1' 
                    || arr[i-1] == '2' && arr[i] >= '0' && arr[i] <= '6'))
                A[i+1] += A[i-1];
        }
        return A[s.length()];
    }
    */
    
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        int p1 = 0;
        int p2 = 1;
        for (int i = 0; i < s.length(); i++) {
            int p3 = 0;
            if (arr[i] != '0') p3 += p2;
            if(i-1 >= 0 
                && (arr[i-1] == '1' 
                    || arr[i-1] == '2' && arr[i] >= '0' && arr[i] <= '6'))
                p3 += p1;
            p1 = p2;
            p2 = p3;
        }
        return p2;
    }
    
    public static void main(String[] args) {
        //int num = new DecodeWays().numDecodings("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565");
        int num = new DecodeWays().numDecodings("012");
        System.out.println(num);
    }
}
