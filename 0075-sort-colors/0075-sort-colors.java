import java.util.Arrays;

class Solution {
    /**
     * Sorts the input array containing only 0s, 1s and 2s in-place using the Dutch National Flag algorithm.
     * The method now safely handles a null input by performing no operation.
     */
    public void sortColors(int[] nums) {
        // Guard against null input to avoid NullPointerException.
        if (nums == null) {
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
            } else if (nums[mid] == 2) {
                // Swap nums[mid] and nums[high], then move high backward
                swap(nums, mid, high);
                high--;
                // Do not increment mid here because the swapped element needs validation
            } else {
                // In case the array contains values other than 0,1,2, we simply move forward.
                // This defensive branch prevents an infinite loop on unexpected input.
                mid++;
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