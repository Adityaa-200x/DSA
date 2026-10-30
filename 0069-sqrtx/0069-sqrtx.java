class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("x must be non-negative");
        }
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int div = x / mid;
            if (mid == div) {
                return mid;
            } else if (mid > div) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }
}