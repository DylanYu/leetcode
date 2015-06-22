package solution;

import java.util.*;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * 
 * Assume that the total area is never beyond the maximum possible value of int.
 * 
 * @author Dongliang Yu
 *
 */
public class RectangleArea {
	// simple solution
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int bottom = Math.max(B, F);
        int top = Math.min(D, H);
        int overlap = 0;
        if ( left < right && bottom < top)
           overlap = area(left, bottom, right, top);
       return area(A, B, C, D) + area(E, F, G, H) - overlap;
    }
    
    private int area(int A, int B, int C, int D) {
        return (C - A) * (D - B);
    }
    
	/*
	class Position {
        int x;
        int y;
        public Position(int x, int y) { this.x = x; this.y = y; }
        public int hashCode() {
        	int ret = 17;
        	ret = ret * 31 + x;
        	ret = ret * 31 + y;
        	return ret;
        }
        public boolean equals(Object obj) {
        	Position that = (Position) obj;
        	return x ==  that.x && y == that.y;
        }
    }
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        Set<Position> points = intersectPoints(A, B, C, D, E, F, G, H);
        points.addAll(insidePoints(A, B, C, D, E, F, G, H));
        return area(A, B, C, D) + area(E, F, G, H) - area(points);
    }
    
    //intersect, including at a line
    private Set<Position> intersectPoints(int A, int B, int C, int D, int E, int F, int G, int H) {
        Set<Position> set = new HashSet<Position>();
        if (intersect(A, B, D, E, G, H)) set.add(new Position(A, H));
        if (intersect(A, B, D, E, G, F)) set.add(new Position(A, F));
        if (intersect(C, B, D, E, G, H)) set.add(new Position(C, H));
        if (intersect(C, B, D, E, G, F)) set.add(new Position(C, F));
        if (intersect(E, F, H, A, C, B)) set.add(new Position(E, B));
        if (intersect(E, F, H, A, C, D)) set.add(new Position(E, D));
        if (intersect(G, F, H, A, C, B)) set.add(new Position(G, B));
        if (intersect(G, F, H, A, C, D)) set.add(new Position(G, D));
        return set;
    }
    
    // line (x, y1) and (x, y2) with line (x3, y) and (x4, y)
    private boolean intersect(int x, int y1, int y2, int x3, int x4, int y) {
        if ((y >= y1 && y <= y2 || y >= y2 && y <= y1)
            && (x >= x3 && x <= x4 || x >= x4 && x <= x3))
            return true;
        else
            return false;
    }
    
    // totally inside, not in a line
    private Set<Position> insidePoints(int A, int B, int C, int D, int E, int F, int G, int H) {
        Set<Position> set = new HashSet<Position>();
        if (inside(A, B, C, D, E, H)) set.add(new Position(E, H));
        if (inside(A, B, C, D, G, H)) set.add(new Position(G, H));
        if (inside(A, B, C, D, G, F)) set.add(new Position(G, F));
        if (inside(A, B, C, D, E, F)) set.add(new Position(E, F));
        if (inside(E, F, G, H, A, D)) set.add(new Position(A, D));
        if (inside(E, F, G, H, C, D)) set.add(new Position(C, D));
        if (inside(E, F, G, H, C, B)) set.add(new Position(C, B));
        if (inside(E, F, G, H, A, B)) set.add(new Position(A, B));
        return set;
    }
    
    private boolean inside(int a, int b, int c, int d, int x, int y) {
        int horizontalDistance1 = Math.abs(x - a);
        int horizontalDistance2 = Math.abs(x - c);
        if (horizontalDistance1 == 0 || horizontalDistance2 == 0
            || horizontalDistance1 + horizontalDistance2 != Math.abs(a - c))
            return false;
        int verticalDistance1 = Math.abs(y - b);
        int verticalDistance2 = Math.abs(y - d);
        if (verticalDistance1 == 0 || verticalDistance2 == 0
            ||verticalDistance1 + verticalDistance2 != Math.abs(b - d))
            return false;
        return true;
    }
    
    private int area(int A, int B, int C, int D) {
        return (C - A) * (D - B);
    }
    
    private int area(Set<Position> positions) {
    	if (positions.size() != 4) return 0;
        ArrayList<Position> list = new ArrayList<Position>();
        for (Position p : positions)
            list.add(p);
        int length = 0;
        int width = 0;
        Position p1 = list.remove(0);
        for (int i = 0; i < 3; i++)
            if (list.get(i).x == p1.x) {
                width = Math.abs(p1.y - list.get(i).y);
                list.remove(i);
                break;
            }
        
        for (int i = 0; i < 2; i++)
        	if (list.get(i).y == p1.y) {
        		 length = Math.abs(p1.x - list.get(i).x);
        		 break;
        	}
        return length * width;
    }
    */
}
