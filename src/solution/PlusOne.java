package solution;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * @author Dongliang Yu
 *
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0) return digits;
        int carry = 1;
        for (int i = len-1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] >= 10) carry = 1;
            else carry = 0;
            digits[i] %= 10;
            if (carry == 0) break;
        }
        if (carry == 1) {
            int[] arr = new int[len+1];
            arr[0] = carry;
            for (int i = 1; i < arr.length; i++)
                arr[i] = digits[i-1];
            digits = arr;
        }
        return digits;
    }
    
    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        digits = plusOne(digits);
        for (int digit : digits)
            System.out.print(digit);
    }
}
