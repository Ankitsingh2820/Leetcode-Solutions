class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        
        int i = 0; // index for positives
        int j = 1; // index for negatives
        
        for (int k = 0; k < n; k++) {
            if (nums[k] > 0) {
                arr[i] = nums[k];
                i += 2; // next position for positive
            } else {
                arr[j] = nums[k];
                j += 2; // next position for negative
            }
        }
        return arr;
    }
}
