/*
    55. Jump Game
    Medium

    You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
    
    Return true if you can reach the last index, or false otherwise.
    
     
    
    Example 1:
    
    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    Example 2:
    
    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
     
    
    Constraints:
    
    1 <= nums.length <= 104
    0 <= nums[i] <= 105
 */
public boolean canJump(int[] nums) {
    int goal = nums.length - 1; //the goal position

    for (int i = nums.length - 2; i >= 0; i--) { //iterate backwards through the array
        if (i + nums[i] >= goal) { //if the current position plus the current jump length is greater than or equal to the goal position, then we can reach the goal position
            goal = i;
        }
    }

    return goal == 0; //if the goal position is 0, then we can reach the goal position
}
void main() {
    //Example 1:
    int[] ex1Nums = {2,3,1,1,4};
    boolean ex1Expected = true;
    boolean ex1Actual = canJump(ex1Nums);
    assert ex1Actual == ex1Expected;
    System.out.println( "Example 1: Expected " + ex1Expected + " Actual " + ex1Actual);
}