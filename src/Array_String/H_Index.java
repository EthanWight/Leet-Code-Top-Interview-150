/*
    274. H-Index
    Medium

    Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

    According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.



    Example 1:

    Input: citations = [3,0,6,1,5]
    Output: 3
    Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
    Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
    Example 2:

    Input: citations = [1,3,1]
    Output: 1


    Constraints:

    n == citations.length
    1 <= n <= 5000
    0 <= citations[i] <= 1000
 */

public int hIndex(int[] citations){
    int n = citations.length; //the number of papers
    int[] buckets = new int[n+1]; //the buckets to store the papers' citation counts'
    for(int c : citations) { //iterate through the papers' citation counts'
        if(c >= n) { //if the citation count is greater than or equal to the number of papers, then we can put it in the last bucket
            buckets[n]++;
        } else { //otherwise, put it in the corresponding bucket
            buckets[c]++;
        }
    }
    int count = 0; //the total number of papers with at least i citations
    for(int i = n; i >= 0; i--) { //iterate through the buckets
        count += buckets[i]; //add the papers' citation counts' to the total number of papers with at least i citations
        if(count >= i) { //if the total number of papers with at least i citations is greater than or equal to i, then we have found the h-index
            return i;
        }
    }
    return 0;
}

void main() {
    //Example 1:
    int[] ex1Nums = {3,0,6,1,5};
    int ex1Expected = 3;
    int ex1Actual = hIndex(ex1Nums);
    assert ex1Actual == ex1Expected;
    System.out.println( "Example 1: Expected " + ex1Expected + " Actual " + ex1Actual);

    //Example 2:
    int[] ex2Nums = {1,3,1};
    int ex2Expected = 1;
    int ex2Actual = hIndex(ex2Nums);
    assert ex2Actual == ex2Expected;
    System.out.println( "Example 2: Expected " + ex2Expected + " Actual " + ex2Actual);
}