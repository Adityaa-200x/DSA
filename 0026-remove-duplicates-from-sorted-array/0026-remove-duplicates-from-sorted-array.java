class Solution {
    public int removeDuplicates(int[] nums) {
        // Guard against null or empty input
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int i = 0;
        int j = 1;
        while (j < n) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}