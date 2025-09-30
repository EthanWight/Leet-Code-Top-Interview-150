/*
    26. Remove Duplicates from Sorted Array
    Easy

    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
    such that each unique element appears only once. The relative order of the elements should be
    kept the same. Then return the number of unique elements in nums.

    Consider the number of unique elements of nums to be k; to get accepted, you need to do the
    following things:

    Change the array nums such that the first k elements of nums contain the unique elements in
    the order they were present in nums initially. The remaining elements of nums are not important
    as well as the size of nums.
    Return k.

    Custom Judge:

    The judge will test your solution with the following code:

    int[] nums = [...]; // Input array
    int[] expectedNums = [...]; // The expected answer with the correct length

    int k = removeDuplicates(nums); // Calls your implementation

    assert k == expectedNums.length;
    for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
    }
    If all assertions pass, then your solution will be accepted.

    Example 1:

    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and
    2 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).

    Example 2:

    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being
    0, 1, 2, 3, and 4 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).


    Constraints:

    1 <= nums.length <= 3 * 104
    -100 <= nums[i] <= 100
    nums is sorted in non-decreasing order.
 */

public int removeDuplicates(int[] nums) {
    //if the array is empty, return 0
    if (nums.length == 0) {
        return 0;
    }
    //declare a pointer k to keep track of the current index of the array nums
    int k = 1;
    //for each element in the array nums, if the current element is not equal to the previous element,
    //then add it to the merged array
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i-1]) {
            nums[k++] = nums[i];
        }
    }
    //return the value of k, which is the number of elements in the merged array
    return k;
}

void main() {

    //Example 1:
    int[] ex1Nums = {1,1,2};
    int[] expectedNums = {1,2};
    int k = removeDuplicates(ex1Nums);
    assert k == expectedNums.length;
    for (int i = 0; i < k; i++) {
        assert ex1Nums[i] == expectedNums[i];
    }
    //Example 2:
    int[] ex2Nums = {0,0,1,1,1,2,2,3,3,4};
    int[] expectedNums2 = {0,1,2,3,4};
    int l = removeDuplicates(ex2Nums);
    assert l == expectedNums2.length;
    for (int j = 0; j < l; j++) {
        assert ex2Nums[j] == expectedNums2[j];
    }
}
