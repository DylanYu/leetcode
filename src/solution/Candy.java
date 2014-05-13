package solution;

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
    public static int candy_bf(int[] ratings) {
        int len = ratings.length;
        int[] candy = new int[len];
        for (int i = 0; i < len; i++)
            candy[i] = 1;
        boolean change = true;
        while (change) {
            change = false;
            for (int i = 0; i < len; i++) {
                if (i - 1 >= 0 && ratings[i-1] < ratings[i] && candy[i-1] >= candy[i]) {
                    candy[i] = candy[i-1] + 1;
                    change = true;
                }
                if (i + 1 < len && ratings[i+1] < ratings[i] && candy[i+1] >= candy[i]) {
                    candy[i] = candy[i+1] + 1;
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
        int[] ratings = {1, 5, 4, 3, 7, 2, 6};
        System.out.println(candy_bf(ratings));
    }
}
