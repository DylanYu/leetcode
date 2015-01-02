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
    /**
     * Although it's short, using Double as key for Map is always a bad idea
     * 
    public int maxPoints(Point[] points) {
        int N = points.length;
        int max = 0;
        for (int i = 0; i < N; i++) {
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int same = 0;
            Point p = points[i];
            int localMax = 0;
            for (int j = i; j < N; j++) { // start from i, the points before i is already considered
                Point q = points[j];
                if (p.x == q.x && p.y == q.y) same++;
                else {
                    long x = (long) p.x - q.x; // deal with possible overflow, and cannot use Math.abs here
                    long y = (long) p.y - q.y;
                    long gcd = gcd(x, y);
                    x = x/gcd;
                    y = y/gcd;
                    double slope;
                    if (x == 0) slope = Double.MAX_VALUE;
                    else slope = (double) y / x;
                    mapInc(map, slope);
                    localMax = Math.max(localMax, map.get(slope));
                }
            }
            localMax += same;
            max = Math.max(max, localMax);
        }
        return max;
    }
    
    private void mapInc(Map<Double, Integer> map, double key) {
        if (!map.containsKey(key)) map.put(key, 1);
        else map.put(key, map.get(key)+1);
    }
    */
    
    class Slope {
        long x;
        long y;
        public Slope(Point p, Point q) { 
            x = (long) p.x - q.x; // deal with possible overflow
            y = (long) p.y - q.y;
            //if (x < 0) { x = -x; y = -y; } // not necessary
            long gcd = gcd(x, y);
            if (gcd != 0) {
                x /= gcd;
                y /= gcd;
            }
            if (x == 0 && y != 0) y = 1;
            if (y == 0 && x != 0) x = 1;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj == this) return true;
            if (!(obj instanceof Slope)) return false;
            Slope that = (Slope) obj;
            return x == that.x && y == that.y;
        }
        
        @Override
        public int hashCode() {
            int ret = 17;
            ret = ret * 31 + (int) (x ^ (x >>> 31)); // unsigned shift, stuff with 0
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
            int coincide = 0;
            int localMax = 0;
            Map<Slope, Integer> map = new HashMap<Slope, Integer>();
            for (int j = i; j < len; j++) { // start from i, the points before i is already considered
                Point p2 = points[j];
                if (p1.x == p2.x && p1.y == p2.y) {
                    coincide++;
                    continue;
                }
                Slope slope = new Slope(p1, p2);
                if (!map.containsKey(slope)) map.put(slope, 0);
                int n =  map.get(slope) + 1;
                map.put(slope, n);
                localMax = Math.max(localMax, n);
            }
            localMax += coincide;
            max = Math.max(max, localMax);
        }
        return max;
    }
    
    private long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a%b);
    }
}
