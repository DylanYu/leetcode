package solution;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater 
 * permutation of numbers.
 * <p>If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, 
 * sorted in ascending order).
 * <p>The replacement must be in-place, do not allocate extra memory.
 * <p>
 * <p>Here are some examples. Inputs are in the left-hand column and its corresponding outputs 
 * are in the right-hand column.
 * <p>1,2,3 → 1,3,2
 * <p>3,2,1 → 1,2,3
 * <p>1,1,5 → 1,5,1
 * 
 * @author Dongliang Yu
 *
 */
public class NextPermutation {
    public static void nextPermutation(int[] num) {
        int length = num.length;
        if (length <= 1)
            return;
        int i = length - 2;
        while (i >= 0) {
            if (num[i] < num[i + 1])
                break;
            i--;
        }
        if (i == -1) { // array in descending order, return the ascending order
            reverse(num, 0, length);
            return;
        }
        int j = i + 1;
        while (j < length) {
            if (num[j] <= num[i]) // first item which smaller/equal than num[i]
                break;
            j++;
        }
        j--; // smallest item which is greater than num[i]
        swap(num, i, j);
        reverse(num, i + 1, length);
    }
    
    private static void swap(int[] num, int a, int b) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }
    
    /**
     * [start, end) 
     */
    private static void reverse(int[] num, int start, int end) {
        int length = num.length;
        if (start < 0 || end > length || start >= end)
            throw new IllegalArgumentException("[start, end) index out of bound");
        int mid = start + (end - start) / 2;
        for (int i = start; i < mid; i++) {
            swap(num, i, end - i - 1 + start);
        }
    }
    
    public static void main(String[] args) {
        //int[] num = {1,4,3,2};
        //int[] num = {3,1,4,4,2,3,4,0,0};
        //int[] num = {5,4,3,2,1};
        //int[] num = {1,2,3,4,5};
        //int[] num = {2,1};
        int[] num = {1, 5, 1};
        nextPermutation(num);
        for (int i = 0; i < num.length; i++)
            System.out.print(num[i]);
    }
}
