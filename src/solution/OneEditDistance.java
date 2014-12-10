package solution;

/**
 * 
 * @author Dongliang Yu
 * 
 * Given two strings S and T, determine if they are both one edit distance apart.
 * 
 * Hint:
 * 1. If | n – m | is greater than 1, we know immediately both are not one-edit distance apart.
 * 2. It might help if you consider these cases separately, m == n and m ≠ n.
 * 3. Assume that m is always ≤ n, which greatly simplifies the conditional statements. If m > n, 
 * we could just simply swap S and T.
 * 4. If m == n, it becomes finding if there is exactly one modified operation. If m ≠ n, you do 
 * not have to consider the delete operation. Just consider the insert operation in T.
 *
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String S, String T) {
        if (S == null && T == null) return false;
        if (S == null || T == null) return false;
        int len1 = S.length();
        int len2 = T.length();
        if (Math.abs(len1-len2) > 1) return false;
        if (len1 == len2) {
            int count = 0;
            for (int i = 0; i < len1; i++)
                if (S.charAt(i) != T.charAt(i)) count++;
            return count <= 1;
        } else {
            if (len1 > len2) {
                String tmp = S;
                S = T;
                T = tmp;
            }
            boolean[] A = new boolean[len1];
            for (int i = 0; i < len1; i++)
                if (S.charAt(i) == T.charAt(i)) A[i] = true;
                else break; // all later elements are set to false
            if (A[len1-1] == true) return true;
            for (int i = 0; i < len1; i++) {
                if (S.charAt(len1-i-1) == T.charAt(len2-i-1)) {
                    if (i == len1-1) return true; // put ahead of later statement to avoid index out of bounds
                    else if (A[len1-i-2]) return true;
                } else
                    return false;
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        String S = "";
        String T = "";
//        S = "abc"; // false
//        T = "a";
        S = "abcde"; // true
        T = "abfde";
//        S = "abcde"; // false
//        T = "abfdf";
//        S = "fbcde"; // false
//        T = "abcdf";
//        S = "abcd"; // true
//        T = "abcde";
//        S = "bcde"; // true
//        T = "abcde";
//        S = "abde"; // true
//        T = "abcde";
//        S = "abc"; // false
//        T = "acd";
        System.out.println(new OneEditDistance().isOneEditDistance(S, T));
    }
}
