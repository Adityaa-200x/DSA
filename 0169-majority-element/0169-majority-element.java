class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must be non-empty");
        }
        int candidate = 0;
        int votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                candidate = num;
                votes = 1;
            } else if (candidate == num) {
                votes++;
            } else {
                votes--;
            }
        }
        return candidate;
    }
}