package solution;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author Dongliang Yu
 *
 */
public class PalindromeNumber {
    // caution about 1000021
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        //if (x <= 9) return true; don't do this to avoid extra work
        int len = 0;
        int tmp = x;
        while (tmp > 0) {
            len++;
            tmp /= 10;
        }
        int divisor = (int) Math.pow(10, len-1);
        while(x > 0) {
            if (x / divisor != x % 10) return false;
            x = (x - x / divisor * divisor) / 10;
            divisor /= 100; // 100 not 10
        }
        return true;
    }
}
