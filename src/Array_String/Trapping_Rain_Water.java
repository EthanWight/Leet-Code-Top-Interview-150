/*
42. Trapping Rainwater
Hard

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rainwater (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */

package Array_String;

public class Trapping_Rain_Water {

    public int trap(int[] height) {

        //Declare variables
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        //Iterate through the array and calculate the total water
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

  static void main() {
        Trapping_Rain_Water solution = new Trapping_Rain_Water();
        
        // Test case 1 from example
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result1 = solution.trap(height1);
        System.out.println("Test Case 1: " + result1); // Expected output: 6
        
        // Test case 2 from example
        int[] height2 = {4, 2, 0, 3, 2, 5};
        int result2 = solution.trap(height2);
        System.out.println("Test Case 2: " + result2); // Expected output: 9
        
        // Additional test case
        int[] height3 = {3, 0, 2, 0, 4};
        int result3 = solution.trap(height3);
        System.out.println("Test Case 3: " + result3); // Expected output: 7
        
        // Edge case: empty array
        int[] height4 = {};
        int result4 = solution.trap(height4);
        System.out.println("Test Case 4 (Empty array): " + result4); // Expected output: 0
        
        // Edge case: no water can be trapped
        int[] height5 = {5, 4, 3, 2, 1};
        int result5 = solution.trap(height5);
        System.out.println("Test Case 5 (No water trapped): " + result5); // Expected output: 0
    }

}
