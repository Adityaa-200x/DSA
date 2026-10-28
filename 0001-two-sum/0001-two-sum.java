import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Validate input
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Input array must contain at least two elements.");
        }
        // hashmap method
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer prevIndex = map.get(complement);
            if (prevIndex != null) {
                return new int[]{prevIndex, i};
            }
            // Store only the first occurrence to keep the earliest index
            map.putIfAbsent(nums[i], i);
        }
        // If no solution is found, signal the error explicitly
        throw new IllegalArgumentException("No two-sum solution exists for the given input.");
    }
}