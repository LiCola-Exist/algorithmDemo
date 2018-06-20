package dp;

/**
 * Created by LiCola on 2018/6/19. Given an integer array nums, find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its sum.
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {



  public static int maxSubArray(int[] A) {
    int maxSum = Integer.MIN_VALUE;
    int curMaxSum = 0;
    for (int i = 0; i < A.length; ++i) {
      curMaxSum = Math.max(curMaxSum + A[i], A[i]);
      maxSum = Math.max(curMaxSum, maxSum);
    }
    return maxSum;
  }
}
