package solution;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author Dongliang Yu
 *
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = i+1;
        
        // reduce unnecessary calculations
        int cycle = factorial(n);
        k = k % cycle;
        if (k == 0) k = cycle;
        
        for (int i = 1; i < k; i++) // iterate k-1 times
            nextPermutation(A);
        StringBuffer sb = new StringBuffer();
        for (int e : A)
            sb.append(e);
        return sb.toString();
    }
    
    private void nextPermutation(int[] A) {
        int i = A.length-2;
        while (i >= 0) {
            if (A[i] < A[i+1]) break;
            i--;
        }
        if (i == -1) { // decending case, reverse back to original state
            reverse(A, 0, A.length-1);
            return;
        }
        int j = i+1;
        while (j < A.length) {
            if (A[j] <= A[i]) break;
            j++;
        }
        j--;
        swap(A, i, j);
        reverse(A, i+1, A.length-1);
    }
    
    private void reverse(int[] A, int lo, int hi) {
        for (int i = lo; i <= lo+(hi-lo)/2; i++) // '=' is necessary here for even number of elements case
            swap(A, i, hi+lo-i);
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    private int factorial(int n) {
        int ret = 1;
        while(n > 1) {
            ret *= n;
            n--;
        }
        return ret;
    }
}
