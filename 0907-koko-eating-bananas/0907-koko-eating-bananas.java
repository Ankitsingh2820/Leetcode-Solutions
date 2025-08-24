class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        int n=piles.length;
        for(int pile:piles)
        {
            high=Math.max(pile,high);
        }
        int ans=high;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(poss( piles, h, mid))
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
    private boolean poss(int[] piles, int h,int k)
    {
        int hours=0;
        for(int pile:piles)
        {
            hours+=(pile+k-1)/k;
            if(hours>h) return false;
        }
        return true;
    }
}