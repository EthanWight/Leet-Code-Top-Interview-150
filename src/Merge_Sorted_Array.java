/*
    88. Merge Sorted Array
    Easy
    Topics
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
    and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function but instead be stored
    inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first
    m elements denote the elements that should be merged, and the last n elements are set to 0
    and should be ignored. nums2 has a length of n.

    Example 1:

    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]
    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

    Example 2:

    Input: nums1 = [1], m = 1, nums2 = [], n = 0
    Output: [1]
    Explanation: The arrays we are merging are [1] and [].
    The result of the merge is [1].

    Example 3:

    Input: nums1 = [0], m = 0, nums2 = [1], n = 1
    Output: [1]
    Explanation: The arrays we are merging are [] and [1].
    The result of the merge is [1].
    Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

    Constraints:

    nums1.length == m + n
    nums2.length == n
    0 <= m, n <= 200
    1 <= m + n <= 200
    -109 <= nums1[i], nums2[j] <= 109

    Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */

public class Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //declare pointers i,j,k to keep track of the current index of nums1, nums2 and the merged array respectively
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        //iterate through the arrays from the end to the beginning
        while(i>=0 && j>=0){
            //if the current element of nums1 is greater than the current element of nums2,
            //then add it to the merged array and decrement the pointer of nums1
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            }
            //otherwise, add the current element of nums2 to the merged array and decrement the pointer of nums2
            else{
                nums1[k--] = nums2[j--];
            }
        }
        //if nums1 has any remaining elements, then add them to the merged array
        while(i>=0){
            nums1[k--] = nums1[i--];
        }
        //if nums2 has any remaining elements, then add them to the merged array
        while(j>=0){
            nums1[k--] = nums2[j--];
        }

    }
    static void main(){

        //Example 1:
        int[] ex1Nums1 = {1,2,3,0,0,0};
        int[] ex1Nums2 = {2,5,6};
        int ex1M= 3;
        int ex1N = 3;
        Merge_Sorted_Array solution = new Merge_Sorted_Array();
        solution.merge(ex1Nums1,ex1M,ex1Nums2,ex1N);
        for (int j : ex1Nums1) {
            System.out.println(j);
        }

        //Example 2:
        int[] ex2Nums1 = {1};
        int[] ex2Nums2 = {};
        int ex2M = 1;
        int ex2N = 0;
        solution.merge(ex2Nums1,ex2M,ex2Nums2,ex2N);
        for (int j : ex2Nums1) {
            System.out.println(j);
        }

        //Example 3:
        int[] ex3Nums1 = {0};
        int[] ex3Nums2 = {1};
        int ex3M = 0;
        int ex3N = 1;
        solution.merge(ex3Nums1,ex3M,ex3Nums2,ex3N);
        for (int j : ex3Nums1) {
            System.out.println(j);
        }
    }

}
