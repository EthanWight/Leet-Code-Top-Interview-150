/*
238. Product of Array Except Self
Medium

Given an integer array nums, return an array answer such that answer[i] is equal to the product
of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not
count as extra space for space complexity analysis.)
 */


public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];

    // answer[i] contains the product of all elements to the left of i
    answer[0] = 1;
    for (int i = 1; i < n; i++) {
        answer[i] = nums[i - 1] * answer[i - 1];
    }

    // R will hold the product of all elements to the right
    int R = 1;
    for (int i = n - 1; i >= 0; i--) {
        // answer[i] = product of left * product of right
        answer[i] = answer[i] * R;
        R *= nums[i];
    }

    return answer;
}


void main() {
    //Example 1:
    int[] ex1Nums = {1,2,3,4};
    int[] ex1Expected = {24,12,8,6};
    int[] ex1Actual = productExceptSelf(ex1Nums);
    assert ex1Actual.length == ex1Expected.length;
    for (int i = 0; i < ex1Actual.length; i++) {
        assert ex1Actual[i] == ex1Expected[i];
        System.out.println("Example 1: " + ex1Actual[i]);
    }

    
}