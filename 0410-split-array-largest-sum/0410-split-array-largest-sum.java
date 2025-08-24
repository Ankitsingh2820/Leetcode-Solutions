class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        
        // search space boundaries
        int low = 0, high = 0;
        for (int num : nums) {
            low = Math.max(low, num); // the largest element (at least this much capacity is needed)
            high += num;              // sum of all elements (max possible capacity)
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                ans = mid;     
                high = mid - 1;
            } else {
                low = mid + 1;  
            }
        }
        return ans;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1; 
        int current = 0;

        for (int num : nums) {
            if (current + num > maxSum) {
               
                count++;
                current = num;
                if (count > k) return false; 
            } else {
                current += num;
            }
        }
        return true;
    }
}
