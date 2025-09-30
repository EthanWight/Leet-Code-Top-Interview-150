/*
    169. Majority Element
    Easy
    Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

    Example 1:

    Input: nums = [3,2,3]
    Output: 3
    Example 2:

    Input: nums = [2,2,1,1,1,2,2]
    Output: 2

    Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109

    Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

public int majorityElement(int[] nums) {
    //integer res to store the majority element
    int res = 0;
    //integer majority to store the count of the majority element
    int majority = 0;

    //iterate through the array nums
    for (int n : nums) {
        //if the majority element count is 0, then set res to the current element
        if (majority == 0) {
            res = n;
        }

        majority += n == res ? 1 : -1; //if the current element is the majority element, then add 1 to the count, otherwise subtract 1 from the count
    }

    return res;
}
void main() {
    //Example 1:
    int[] ex1Nums = {3,2,3};
    int ex1Expected = 3;
    int ex1Actual = majorityElement(ex1Nums);
    assert ex1Actual == ex1Expected;

    //Example 2:
    int[] ex2Nums = {2,2,1,1,1,2,2};
    int ex2Expected = 2;
    int ex2Actual = majorityElement(ex2Nums);
    assert ex2Actual == ex2Expected;
    
}