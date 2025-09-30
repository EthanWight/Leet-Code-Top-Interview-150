/*
    80. Remove Duplicates from Sorted Array II
    Medium
    Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place
    such that each unique element appears at most twice. The relative order of the elements should
    be kept the same.

    Since it is impossible to change the length of the array in some languages, you must instead
    have the result be placed in the first part of the array nums. More formally, if there are k
    elements after removing the duplicates, then the first k elements of nums should hold the final
    result. It does not matter what you leave beyond the first k elements.

    Return k after placing the final result in the first k slots of nums.

    Do not allocate extra space for another array. You must do this by modifying the input array
    in-place with O(1) extra memory.

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

    Input: nums = [1,1,1,2,2,3]
    Output: 5, nums = [1,1,2,2,3,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).
    Example 2:

    Input: nums = [0,0,1,1,1,1,2,3,3]
    Output: 7, nums = [0,0,1,1,2,3,3,_,_]
    Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).


    Constraints:

    1 <= nums.length <= 3 * 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.
 */
public int removeDuplicates(int[] nums) {
    int writeIndex = 1; //the index of the next element to write to
    int duplicateCount = 0; //the number of duplicates seen so far
    int prevElement = nums[0]; //the previous element seen

    //iterate through the array, skipping the first element since it has already been written to
    for (int i = 1; i < nums.length; i++) {
        //if the current element is not equal to the previous element, then reset the duplicate count to 0
        if (nums[i] != prevElement) {
            duplicateCount = 0;
        } else {
            duplicateCount++;
        }
        //if the current element is not a duplicate, then write it to the array and increment the writing index
        if (duplicateCount <= 1) {
            nums[writeIndex++] = nums[i];
            prevElement = nums[i];
        }
    }
    //return the writing index, which is the number of elements written to the array
    return writeIndex;
}

void main() {
    //Example 1:
    int[] ex1Nums = {1,1,1,2,2,3};
    int[] ex1ExpectedNums = {1,1,2,2,3};
    int ex1K = removeDuplicates(ex1Nums);
    assert ex1K == ex1ExpectedNums.length;
    for (int i = 0; i < ex1K; i++) {
        assert ex1Nums[i] == ex1ExpectedNums[i];
    }

    //Example 2:
    int[] ex2Nums = {0,0,1,1,1,1,2,3,3};
    int[] ex2ExpectedNums = {0,0,1,1,2,3,3};
    int ex2K = removeDuplicates(ex2Nums);
    assert ex2K == ex2ExpectedNums.length;
    for (int i = 0; i < ex2K; i++) {
        assert ex2Nums[i] == ex2ExpectedNums[i];
    }
}
