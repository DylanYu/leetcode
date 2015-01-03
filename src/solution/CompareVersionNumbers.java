package solution;

/**
 * Compare two version numbers version1 and version1.
 * 
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . 
 * character.
 * 
 * The . character does not represent a decimal point and is used to separate number sequences.
 * 
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth 
 * second-level revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author Dongliang Yu
 *
 */
public class CompareVersionNumbers {
    /**
     * Cases: (1.0, 1), (1.0.0, 1), (1.2, 1), (.2, 0.2), (1..1, 1.0.1)
     */
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) return 0;
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        int i = 0; int j = 0;
        while (i < v1.length || j < v2.length) {
            int n1 = 0; int n2 = 0;
            while (i < v1.length && v1[i] != '.')
                n1 = n1 * 10 + (v1[i++]-'0');
            while (j < v2.length && v2[j] != '.')
                n2 = n2 * 10 + (v2[j++]-'0');
            if (n1 > n2) return 1;
            else if (n1 < n2) return -1;
            i++; // not bother when out of bound
            j++; // not bother when out of bound
        }
        return 0;
    }
    
    /*
    // scan and return current version segment, store start index of next
    // version segment to nxtIdx[0]
    private int getVersion(char[] c, int idx, int[] nxtIdx) {
        if (idx >= c.length) {
            // this version is finished, return 0 as current version segment
            nxtIdx[0] = c.length;
            return 0;
        }
        int num = 0;
        while (idx < c.length && c[idx] != '.')
            num = num * 10 + (c[idx++] - '0');
        if (idx >= c.length) nxtIdx[0] = idx;
        else nxtIdx[0] = idx + 1; // skip the '.'
        return num;
    }
    
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null || 
                version1.length() == 0 || version2.length() == 0)
            return 0; // Exception
        char[] c1 = version1.toCharArray();
        char[] c2 = version2.toCharArray();
        int i = 0; int j = 0;
        // when only one version is finished we should keep scanning another version
        while (i < c1.length || j < c2.length) {
            int[] nxtIdx = new int[1];
            int n1 = getVersion(c1, i, nxtIdx);
            i = nxtIdx[0];
            int n2 = getVersion(c2, j, nxtIdx);
            j = nxtIdx[0];
            if (n1 > n2) return 1;
            else if (n1 < n2) return -1;
        }
        return 0; // equals when both are finished and still no winner
    }
    */
}
