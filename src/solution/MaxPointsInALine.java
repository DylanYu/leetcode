package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number 
 * of points that lie on the same straight line.
 * 
 * @author Dongliang Yu
 *
 */
public class MaxPointsInALine {
    class Slope {
        long x;
        long y;
        Slope(long a, long b) { x = a; y = b; }
        
        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Slope)) return false;
            Slope that = (Slope) obj;
            return x == that.x && y == that.y;
        }
        
        @Override
        public int hashCode() {
            int ret = 17;
            ret = ret * 31 + (int) (x ^ (x >>> 31));
            ret = ret * 31 + (int) (y ^ (y >>> 31));
            return ret;
        }
    }
    
    public int maxPoints(Point[] points) {
        int len = points.length;
        if (len <= 2) return len;
        
        int max = 0;
        for (int i = 0; i < len; i++) {
            Point p1 = points[i];
            int coincide = 1;
            int localMax = 0;
            Map<Slope, Integer> map = new HashMap<Slope, Integer>();
            for (int j = i+1; j < len; j++) {
                Point p2 = points[j];
                if (p1.x == p2.x && p1.y == p2.y) {
                    coincide++;
                    continue;
                }
                long x = p1.x - p2.x; // deal with possible overflow
                long y = p1.y - p2.y;
                Slope slope;
                if (x == 0) {
                    // special vertical case.
                    slope = new Slope(0, 1);
                } else {
                    long gcd = gcd(x, y);
                    slope = new Slope(x/gcd, y/gcd);
                }
                if (!map.containsKey(slope)) map.put(slope, 0);
                int n =  map.get(slope) + 1;
                map.put(slope, n);
                if (n > localMax) localMax = n;
            }
            localMax += coincide;
            if (localMax > max) max = localMax;
        }
        return max;
    }
    
    private long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a%b);
    }
}
