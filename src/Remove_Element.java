/*
    27. Remove Element
    Easy

    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
    The order of the elements may be changed. Then return the number of elements in nums that is
    not equal to val.

    Consider the number of elements in nums which are not equal to val be k, to get accepted, you
    need to do the following things:

    Change the array nums such that the first k elements of nums contain the elements which are not
    equal to val. The remaining elements of nums are not important as well as the size of nums.
    Return k.

    Custom Judge:

    The judge will test your solution with the following code:

    int[] nums = [...]; // Input array
    int val = ...; // Value to remove
    int[] expectedNums = [...]; // The expected answer with the correct length.
                                // It is sorted with no values equaling val.

    int k = removeElement(nums, val); // Calls your implementation

    assert k == expectedNums.length;
    sort(nums, 0, k); // Sort the first k elements of nums
    for (int i = 0; i < actualLength; i++) {
        assert nums[i] == expectedNums[i];
    }

    If all assertions pass, then your solution will be accepted.

    Example 1:

    Input: nums = [3,2,2,3], val = 3
    Output: 2, nums = [2,2,_,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 2.
    It does not matter what you leave beyond the returned k (hence they are underscores).
    Example 2:

    Input: nums = [0,1,2,2,3,0,4,2], val = 2
    Output: 5, nums = [0,1,4,0,3,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
    Note that the five elements can be returned in any order.
    It does not matter what you leave beyond the returned k (hence they are underscores).

    Constraints:

    0 <= nums.length <= 100
    0 <= nums[i] <= 50
    0 <= val <= 100
*/

import static java.util.Arrays.sort;

public int removeElement(int[] nums, int val) {
    //declare a pointer k to keep track of the current index of the array nums
    int k = 0;
    //iterate through the array nums and if the current element is not equal to val,
    //then add it to the merged array and decrement the pointer of nums
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
            nums[k++] = nums[i];
        }
    }
    //return the value of k, which is the number of elements in the merged array
    return k;

}

void main() {

    //Example 1:
    int[] nums1 = {3, 2, 2, 3}; // Input array
    int val1 = 3; // Value to remove
    int[] expectedNums1 = {2, 2}; // The expected answer with the correct length.
    // It is sorted with no values equaling val.
    int k = removeElement(nums1, val1); // Calls your implementation
    assert k == expectedNums1.length;
    sort(nums1, 0, k); // Sort the first k elements of nums
    for (int i = 0; i < nums1.length; i++) {
        assert nums1[i] == expectedNums1[i];
    }

    //Example 2:
    int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2}; // Input array
    int val2 = 2; // Value to remove
    int[] expectedNums2 = {0, 1, 4, 0, 3}; // The expected answer with the correct length.
    // It is sorted with no values equaling val.
    int l = removeElement(nums2, val2); // Calls your implementation
    assert l == expectedNums2.length;
    sort(nums2, 0, k); // Sort the first k elements of nums
    for (int i = 0; i < nums2.length; i++) {
        assert nums2[i] == expectedNums2[i];
    }
}
