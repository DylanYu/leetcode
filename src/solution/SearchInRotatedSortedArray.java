package solution;

public class SearchInRotatedSortedArray {
    private static int len;
    private static int shift;

    public static int search(int[] A, int target) {
        len = A.length;
        shift = 0;
        for (int i = 1; i < len; i++) {
            if (A[i] < A[i-1]) {
                shift = i;
                break;
            }
        }
        return binarySearch(A, 0, len - 1, target);
    }
    
    private static int binarySearch(int[] A, int lo, int hi, int target) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (A[convert(mid)] == target) return convert(mid);
        else if (A[convert(mid)] < target) return binarySearch(A, mid + 1, hi, target);
        else return binarySearch(A, lo, mid - 1, target);
    }
    
    private static int convert(int index) {
        return (index + shift) % len;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(A, 1));
    }
}