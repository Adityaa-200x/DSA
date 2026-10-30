class Solution {
    /**
     * Returns the maximum sum of a contiguous subarray.
     *
     * @param nums an array of integers; must contain at least one element
     * @return the maximum subarray sum
     * @throws IllegalArgumentException if {@code nums} is null or empty
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must contain at least one element.");
        }
        int sum = 0;
        int maxi = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxi) {
                maxi = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxi;
    }
}