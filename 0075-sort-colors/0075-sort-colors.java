import java.util.Arrays;

class Solution {
    public void sortColors(int[] nums) {
        // Guard against null or trivial inputs
        if (nums == null || nums.length <= 1) {
            return;
        }
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid], then move both pointers forward
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Element is in the correct middle region, just move mid forward
                mid++;
            } else { // nums[mid] == 2
                // Swap nums[mid] and nums[high], then move high backward
                swap(nums, mid, high);
                high--;
                // Do not increment mid here because the swapped element needs validation
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] originalArray = {2, 0, 2, 1, 1, 0};
        
        System.out.println("Before: " + Arrays.toString(originalArray));
        solver.sortColors(originalArray);
        System.out.println("After:  " + Arrays.toString(originalArray));
    }
}