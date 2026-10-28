import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Guard against null or insufficient input
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
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
        // No solution found – return empty array as per contract
        return new int[0];
    }
}