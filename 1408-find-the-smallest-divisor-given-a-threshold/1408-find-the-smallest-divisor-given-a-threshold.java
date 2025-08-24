class Solution {
    public int smallestDivisor(int[] nums, int threshold) 
    {
        int low=1;
        int high=0;

        for(int num:nums)
        {
             high = Math.max(high, num);
        }
        int ans=high;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(can( nums, threshold,mid))
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
        
    }
    private boolean can(int[] nums, int threshold,int k)
    {
        int count=0;
        for(int num:nums)
        {
            count+=(num+k-1)/k;
            if(count>threshold) return false;

        }
        return true;
    }
}