package solution;

public class RemoveElement {
    // more efficient
    public int removeElement(int[] A, int elem) {
        if (A.length == 0) return 0;
        int i = 0;
        int j = A.length-1;
        while (i <= j) {
            if (A[i] == elem) {
                A[i] = A[j];
                j--;
            }
            else
                i++;
        }
        return j + 1;
    }
    
    /* less efficient but interesting solution
    public int removeElement(int[] A, int elem) {
        if (A.length == 0) return 0;
        int i = 0;
        int n = 0;
        while (i < A.length) {
            if (A[i] != elem) A[n++] = A[i];
            i++;
        }
        return n;
    }
    */
}
