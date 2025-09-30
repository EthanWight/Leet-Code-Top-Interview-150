package Array_String;

/*
    189. Rotate Array
    Medium

    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

    Example 1:

    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 step to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
    Example 2:

    Input: nums = [-1,-100,3,99], k = 2
    Output: [3,99,-1,-100]
    Explanation:
    rotate 1 step to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]

    Constraints:

    1 <= nums.length <= 105
    -231 <= nums[i] <= 231 - 1
    0 <= k <= 105

    Follow up:

    Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
    Could you do it in-place with O(1) extra space?
 */

public class Rotate_Array {

    /**
     * Rotates the array to the right by k steps in-place.
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return; // nothing to do for empty or single-element arrays

        // Normalize k to avoid extra rotations when k >= n
        k = k % n;
        if (k == 0) return; // rotating by a multiple of n does nothing

        // 1) Reverse the entire array
        reverse(nums, 0, n - 1);
        // 2) Reverse the first k elements (which were the original tail)
        reverse(nums, 0, k - 1);
        // 3) Reverse the remaining n-k elements (which were the original head)
        reverse(nums, k, n - 1);
    }

    /**
     * Helper that reverses the subarray nums[start.end] in-place.
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    static void main() {
        // Example 1
        int[] ex1Nums = {1, 2, 3, 4, 5, 6, 7};
        int ex1K = 3;
        int[] expectedNums = {5, 6, 7, 1, 2, 3, 4};

        Rotate_Array solution = new Rotate_Array();
        System.out.println("Original array: " + java.util.Arrays.toString(ex1Nums));
        solution.rotate(ex1Nums, ex1K);
        System.out.println("Rotated array:  " + java.util.Arrays.toString(ex1Nums));

        for (int i = 0; i < ex1Nums.length; i++) {
            assert ex1Nums[i] == expectedNums[i];
        }
        System.out.println("All tests passed!");
    }
}