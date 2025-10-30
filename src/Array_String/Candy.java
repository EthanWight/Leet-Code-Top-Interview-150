package Array_String;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

    static void main(String[] args) {
        Candy solution = new Candy();
        
        // Test case 1: [1,0,2]
        // Expected: 5 (2 + 1 + 2)
        int[] ratings1 = {1, 0, 2};
        int result1 = solution.candy(ratings1);
        System.out.println("Test case 1:");
        System.out.println("Ratings: " + Arrays.toString(ratings1));
        System.out.println("Minimum candies needed: " + result1);
        System.out.println("Expected: 5");
        System.out.println("Test passed: " + (result1 == 5));
        System.out.println();
        
        // Test case 2: [1,2,2]
        // Expected: 4 (1 + 2 + 1)
        int[] ratings2 = {1, 2, 2};
        int result2 = solution.candy(ratings2);
        System.out.println("Test case 2:");
        System.out.println("Ratings: " + Arrays.toString(ratings2));
        System.out.println("Minimum candies needed: " + result2);
        System.out.println("Expected: 4");
        System.out.println("Test passed: " + (result2 == 4));
        System.out.println();
        
        // Test case 3: [1,3,4,5,2]
        // Expected: 11 (1 + 2 + 3 + 4 + 1)
        int[] ratings3 = {1, 3, 4, 5, 2};
        int result3 = solution.candy(ratings3);
        System.out.println("Test case 3:");
        System.out.println("Ratings: " + Arrays.toString(ratings3));
        System.out.println("Minimum candies needed: " + result3);
        System.out.println("Expected: 11");
        System.out.println("Test passed: " + (result3 == 11));
    }
}