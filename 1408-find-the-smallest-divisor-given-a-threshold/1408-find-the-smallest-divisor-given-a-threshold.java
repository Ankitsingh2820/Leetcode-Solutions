class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 0;
        for (int num : nums) {
            right = Math.max(right, num);  // maximum possible divisor
        }

        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDivide(nums, threshold, mid)) {
                ans = mid;         // possible answer
                right = mid - 1;   // try smaller divisor
            } else {
                left = mid + 1;    // need bigger divisor
            }
        }
        return ans;
    }

    // Check if divisor d works
    private boolean canDivide(int[] nums, int threshold, int d) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + d - 1) / d;  // ceil(num/d)
            if (sum > threshold) return false; // early exit
        }
        return sum <= threshold;
    }
}
