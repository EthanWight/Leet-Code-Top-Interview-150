/*
    45. Jump Game II
    Medium

    You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.

    Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:

    0 <= j <= nums[i] and
    i + j < n
    Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.



    Example 1:

    Input: nums = [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
    Example 2:

    Input: nums = [2,3,0,1,4]
    Output: 2


    Constraints:

    1 <= nums.length <= 104
    0 <= nums[i] <= 1000
    It's guaranteed that you can reach nums[n - 1].
 */

public int jump(int[] nums) {
    int near = 0; // the index of the next element to be considered for a jump
    int far = 0; // the index of the farthest element reachable from the current index
    int jumps = 0; // the number of jumps taken so far

    while (far < nums.length - 1) { // while we haven't reached the end of the array'
        int farthest = 0; // the farthest element reachable from the current index
        for (int i = near; i <= far; i++) { // iterate through the elements between near and far
            farthest = Math.max(farthest, i + nums[i]);
        }
        near = far + 1; // update the next index to consider for a jump
        far = farthest; // update the farthest reachable index
        jumps++; // increment the number of jumps taken
    }

    return jumps;
}

void main() {
    //Example 1:
    int[] ex1Nums = {2,3,1,1,4};
    int ex1Expected = 2;
    int ex1Actual = jump(ex1Nums);
    assert ex1Actual == ex1Expected;
    System.out.println( "Example 1: Expected " + ex1Expected + " Actual " + ex1Actual);
}