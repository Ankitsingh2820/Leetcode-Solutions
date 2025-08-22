class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length; // high = n

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {
                low = mid + 1;  // go right
            } else {
                high = mid;     // keep mid as possible answer
            }
        }

        return low; // index where target should be inserted
    }
}
