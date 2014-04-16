package solution;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * @author Dongliang Yu
 *
 */
public class RemoveDuplicatesII {
    public static int removeDuplicates(int[] A) {
        int length = A.length;
        if (length < 3)
            return length;
        int skipped = 0;
        int i = 2;
        while (i < length) {
            if (A[i] == A[i - 1 - skipped] && A[i] == A[i - 2 - skipped]) {
                skipped++;
            } else {
                A[i - skipped] = A[i];
            }
            i++;
        }
        return length - skipped;
    }
}
