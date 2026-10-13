import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Guard against null or insufficient input
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // Use long to avoid overflow when computing the needed complement
            long needLong = (long) target - (long) nums[i];
            if (needLong >= Integer.MIN_VALUE && needLong <= Integer.MAX_VALUE) {
                int need = (int) needLong;
                if (map.containsKey(need)) {
                    return new int[] { map.get(need), i };
                }
            }
            // Store the current number and its index
            map.put(nums[i], i);
        }
        // No solution found – return empty array as per original contract
        return new int[0];
    }
}