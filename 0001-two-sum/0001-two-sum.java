import java.util.*;

class Solution {
    /**
     * Returns indices of the two numbers such that they add up to the target.
     * If the input array is null, empty, or has fewer than two elements, an empty array is returned.
     */
    public int[] twoSum(int[] nums, int target) {
        // Defensive null/size check
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        // hashmap method
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int numneed = target - nums[i];
            if (map.containsKey(numneed)) {
                return new int[] { map.get(numneed), i };
            }
            // Store the index of the current number for future complement look-ups
            map.put(nums[i], i);
        }
        // No solution found - return empty array as per defensive contract
        return new int[0];
    }
}