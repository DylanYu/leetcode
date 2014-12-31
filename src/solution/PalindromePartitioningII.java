package solution;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * @author Dongliang Yu
 *
 */
public class PalindromePartitioningII {
    // DP, O(N^2), no recursion in main DP
    public int minCut(String s) {
        if (s == null) return -1;
        int len = s.length();
        int[][] pal = new int[len][len]; // -1 - init; 0 - false; 1 - true
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                pal[i][j] = -1;
        for (int i = 0; i < len; i++) pal[i][i] = 1;
        for (int i = 1; i < len; i++) pal[i-1][i] = (s.charAt(i-1) == s.charAt(i) ? 1 : 0);
        
        int[] A = new int[len+1];
        A[0] = -1; // special meaning
        for (int i = 1; i < len+1; i++) {
            int currMinCut = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (isPalindrome(s, pal, j-1, i-1)) {
                    int cut = A[j-1] + 1;
                    currMinCut = Math.min(currMinCut, cut);
                    if (currMinCut == 0) break; // already minimum
                }
            }
            A[i] = currMinCut;
        }
        return A[len];
    }
    
    /* DP, O(N^2)
     * A[i] - min cut of [0, i];
     * pal[i][j] - if s.substring(i, j+1) is palindrome, use DP to avoid brute force search
     *
    public int minCut(String s) {
        if (s == null) return 0;
        int len = s.length();
        if (s.length() <= 1) return 0;
        int[] A = new int[len];
        int[][] pal = new int[len][len];
        for (int i = 0; i < len; i++)
            A[i] = -1;
        //A[0] = 0; // later logic can set this up
        return minCut(A, pal, s, len-1);
    }
    
    // [0, curr]
    private int minCut(int[] A, int[][] pal, String s, int curr) {
        if (curr < 0) return -1; // for [0,curr] is palindrome case, 1 + (-1) = 0
        if (A[curr] != -1) return A[curr];
        int min = Integer.MAX_VALUE;
        for (int i = curr; i >= 0; i--) {
            if (isPalindrome(s, pal, i, curr) == 1) {
                int cut = 1 + minCut(A, pal, s, i-1); // i-1 == -1: [0,curr] is palindrome
                if (cut < min) min = cut;
                //if (min == 0) break; // minor improvement
            }
        }
        A[curr] = min;
        return A[curr];
    }
    */
    
    private boolean isPalindrome(String s, int[][] pal, int i, int j) {
        if (pal[i][j] != -1) return pal[i][j] == 1;
        pal[i][j] = (isPalindrome(s, pal, i+1, j-1) && s.charAt(i) == s.charAt(j)) ? 1 : 0;
        return pal[i][j] == 1;
    }
    
    /* BFS, O(N^3), not efficient
     * 
    public int minCut(String s) {
        if (s == null || s.length() <= 1) return 0;
        Queue<String> queue = new LinkedList<String>();
        queue.add(s);
        queue.add(null);
        int n = 0;
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr == null) {
                n++;
                queue.add(null);
                continue;
            }
            if (isPalindrome(curr)) return n;
            for (String e : split(curr))
                queue.add(e);
        }
        return n; // not possible;
    }
    
    private List<String> split(String s) {
        List<String> ret = new LinkedList<String>();
        for (int i = 1; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i)))
                ret.add(s.substring(i));
        }
        return ret;
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()/2; i++)
            if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        return true;
    }
    */
    
    public static void main(String[] args) {
        //String s = "eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj";
        String s = "fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi";
        //String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(new PalindromePartitioningII().minCut(s));
    }
}
