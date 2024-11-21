package com.rishabhrahul.map.EPI;

public class TwoPointer implements Comparable<Integer> {


    @Override
    public int compareTo(Integer that) {
        return 0;
    }

    /**
     *
     * @param array given array
     * @param TargetSum value of the sub-array
     * @return length of the window with nearest value to TargetSum
     */

    int LongestSubArraySum(int[] array, int TargetSum, int start, int end) {
        int maxLength = 0;
        int myTargetSum = 0;
        while ( end < array.length ) {
            myTargetSum += array[end];

            while ( myTargetSum > TargetSum && start <= end ) {
                myTargetSum -= array[start];
                start++;
            }

            if (myTargetSum == TargetSum) maxLength =  Math.max( end-start+1, maxLength);

            end++;
        }
        return maxLength;
    }

    /**
     * Maximum Sum of Subarray of Size k
     * @param array
     * @param TargetSize
     * @return
     */
    int MaximumSumSubArraySizeK(int[] array, int TargetSize) {
        // here we have to make a windown of size k and then we have to tarvel
        int mySum = 0;
        int startIndex = 0;
        int endIndex = 0;
        int maxSum = 0;
        while(endIndex <= array.length) {
            mySum += array[endIndex];

            if(endIndex - startIndex > TargetSize) {
                mySum -= array[startIndex];
                maxSum = Math.max(maxSum, mySum);
                startIndex++;
            }

            endIndex++;

        }
    return mySum;
    }


}
