class Solution {
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int sums=nums[0];
           for (int i = 1; i < nums.length; i++)
           {
            sum=Math.max(nums[i],sum+nums[i]);
            sums=Math.max(sum,sums);
           }
           return sums;
        
    }
}