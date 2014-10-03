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
	// search from head and then from tail, it is easy
	public static int candy(int[] ratings) {
        int len = ratings.length;
        int[] num = new int[len];
        num[0] = 1;
        for (int i = 1; i < len; i++) {
            num[i] = 1;
            if (ratings[i] > ratings[i-1]) num[i] = num[i-1] + 1;
        }
        for (int i = len-2; i >= 0; i--)
            if (ratings[i] > ratings[i+1]) num[i] = Math.max(num[i], num[i+1]+1);
        int sum = 0;
        for (int e : num) sum += e;
        return sum;
    }
	
	/**
    public static int candy(int[] ratings) {
        int len = ratings.length;
        int number = 1;
        int i = 1;
        int lastTop = 1;
        while (i < len) {
            if (ratings[i] > ratings[i-1]) {
                int top = 1;
                while (i < len && ratings[i] > ratings[i-1]) {
                    top++;
                    i++;
                }
                number -= 1; // delete start node's rating, which is always 1
                number += top * (top + 1) / 2;
                lastTop = top;
            } else if (ratings[i] < ratings[i-1]) {
                int top = 1;
                while (i < len && ratings[i] < ratings[i-1]) {
                    top++;
                    i++;
                }
                if (top > lastTop)  number -= lastTop;
                else                top--;
                number += top * (top + 1) / 2;
                lastTop = top;
            } else if (ratings[i] == ratings[i-1]) {
                number += 1;
                i++;
                lastTop = 1;
            }
        }
        return number;
    }
    */
    
    /*****************************************************/
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

    public static int candyWithNode(int[] ratings) {
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
            if (walker.l == -1 && walker.r == -1 ||    // 90°
                    walker.l == 0 && walker.r == -1 || // 135°
                    walker.l == -1 && walker.r == 0)   // 135°
                valleys.add(walker);
            walker = walker.right;
        }
        // for each valley, scan its left and right part
        Node head = dummyhd.right;
        head.left = null; // delete dummy head
        dummyhd = null;
        for (Node v : valleys) {
            walker = v.left;
            while (walker != null) {
                if (walker.r == 1)
                    walker.candy = Math.max(walker.candy, walker.right.candy + 1);
                else
                    break; // stop at turn point (less or equal)
                walker = walker.left;
            }
            walker = v.right;
            while (walker != null) {
                if (walker.l == 1)
                    walker.candy = walker.left.candy + 1; // not possible to lower the value
                else
                    break; // stop at turn point (less or equal)
                walker = walker.right;
            }
        }
        // collect result
        walker = head;
        int number = 0;
        while (walker != null) {
            number += walker.candy;
            walker = walker.right;
        }
        return number;
    }

    /*****************************************************/
    public static int candyBF(int[] ratings) {
        int len = ratings.length;
        int[] candy = new int[len];
        for (int i = 0; i < len; i++)
            candy[i] = 1;
        boolean change = true;
        while (change) {
            change = false;
            for (int i = 0; i < len; i++) {
                if (i - 1 >= 0 && ratings[i - 1] < ratings[i] && candy[i - 1] >= candy[i]) {
                    candy[i] = candy[i - 1] + 1;
                    change = true;
                }
                if (i + 1 < len && ratings[i + 1] < ratings[i] && candy[i + 1] >= candy[i]) {
                    candy[i] = candy[i + 1] + 1;
                    change = true;
                }
            }
        }
        int number = 0;
        for (int e : candy)
            number += e;
        return number;
    }

    public static void main(String[] args) {
        int[] ratings = { 0, 1, 1, 1, 5, 4, 4, 4, 3, 2, 1, 7, 2, 3, 6, 6, 6, 7 };
        System.out.println(candy(ratings));
        System.out.println(candyWithNode(ratings));
        System.out.println(candyBF(ratings));
    }
}
