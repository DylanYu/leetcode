package solution;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space (size that is greater or equal to 
 * m + n) to hold additional elements from B. The number of elements 
 * initialized in A and B are m and n respectively.
 * 
 * @author Dongliang Yu
 *
 */
public class MergeSortedArray {
    // merge from large to small to eliminate copying
    public void merge(int A[], int m, int B[], int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) A[k--] = A[i--]; // > not <
            else A[k--] = B[j--];
        }
        if (i == -1)
            while (j >= 0) A[k--] = B[j--];
        else
            return;
    }
    
    /*
    public void merge(int A[], int m, int B[], int n) {
        if (n <= 0)
            return;
        if (m == 0 || A[m - 1] <= B[0]) {
            for (int i = 0; i < n; i++)
                A[m + i] = B[i];
            return;
        }

        // copy from end to start to avoid poisoning data
        for (int i = m - 1; i >= 0; i--)
            A[i + n] = A[i];
        int length = m + n;
        int i = 0;
        int j = n;
        int k = 0;
        while (j < length && k < n) {
            if (A[j] <= B[k])
                A[i++] = A[j++];
            else
                A[i++] = B[k++];
        }
        if (j == length)
            while (k < n)
                A[i++] = B[k++];
        else // after walking through B, it is already merged 
            return;
    }
    */
}
