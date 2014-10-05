package solution;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two 
 * sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * @author Dongliang Yu
 *
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int l1 = A.length;
        int l2 = B.length;
        int len = l1 + l2;
        if (len % 2 == 1) return getKth(A, 0, l1-1, B, 0, l2-1, len/2+1);
        else return (getKth(A, 0, l1-1, B, 0, l2-1, len/2)
                        + getKth(A, 0, l1-1, B, 0, l2-1, len/2+1)) / 2.0;
    }
    
    // k start from 1
    private int getKth(int A[], int lo1, int hi1, int B[], int lo2, int hi2, int k) {
        // let A shorter than B
        if (hi1-lo1 > hi2-lo2) return getKth(B, lo2, hi2, A, lo1, hi1, k);
        if (lo1 > hi1) return B[lo2+k-1];
        if (k == 1) return Math.min(A[lo1], B[lo2]);
        
        int i = Math.min(hi1-lo1+1, k/2);
        int j = Math.min(hi2-lo2+1, k/2);
        if (A[lo1+i-1] > B[lo2+j-1])
            return getKth(A, lo1, hi1, B, lo2+j, hi2, k-j);
        else
            return getKth(A, lo1+i, hi1, B, lo2, hi2, k-i);
    }
}
