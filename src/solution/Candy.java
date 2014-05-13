package solution;

import java.util.ArrayList;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <ul>
 * <li>Each child must have at least one candy.
 * <li>Children with a higher rating get more candies than their neighbors.
 * </ul>
 * <p>
 * What is the minimum candies you must give?
 * 
 * @author Dongliang Yu
 *
 */
public class Candy {
    static class Node {
        int rating;
        int candy;
        Node left;
        int l; // -1, 0, 1 : less, equal, greater
        Node right;
        int r; // -1, 0, 1 : less, equal, greater
        public Node(int r) {
            rating = r;
            candy = 1;
            left = null;
            l = -1;
            right = null;
            r = -1;
        }
    }
    
    public static int candy(int[] ratings) {
        Node dummyhd = new Node(Integer.MAX_VALUE);
        Node walker = dummyhd;
        for (int e : ratings) {
            Node node = new Node(e);
            walker.right = node;
            node.left = walker;
            if (walker.rating > node.rating) {
                walker.r = 1;
                node.l = -1;
            } else if (walker.rating < node.rating) {
                walker.r = -1;
                node.l = 1;
            } else {
                walker.r = 0;
                node.l = 0;
            }
            walker = node;
        }
        // find all valleys
        ArrayList<Node> valleys = new ArrayList<Node>();
        walker = dummyhd.right;
        while (walker != null) {
            if (walker.l == -1 && walker.r == -1 ||
                    walker.l == 0 && walker.r == -1)
                // TODO
                valleys.add(walker);
            walker = walker.right;
        }
        // for each valley, scan its left and right part
        for (Node v : valleys) {
            walker = v.left;
            while (walker != dummyhd) {
                // TODO
                if (walker.r == 1)
                    walker.candy = Math.max(walker.candy, walker.right.candy + 1);
                else if (walker.r == 0)
                    walker.candy = walker.right.candy;
                else // break at turn down point
                    break;
                walker = walker.left;
            }
            walker = v.right;
            while (walker != null) {
                // TODO
                if (walker.l == 1)
                    walker.candy = Math.max(walker.candy, walker.left.candy + 1);
                else // break at turn point and equal case (no need to deal with equal cases twice)
                    break;
                walker = walker.right;
            }
        }
        // collect result
        walker = dummyhd.right;
        int number = 0;
        while (walker != null) {
            number += walker.candy;
            walker = walker.right;
        }
        return number;
    }
    
    public static void main(String[] args) {
        int[] ratings = {1, 5, 4, 3, 7, 2, 6};
        System.out.println(candy(ratings));
    }
}
