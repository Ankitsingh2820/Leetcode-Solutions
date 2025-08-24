class Solution {
    public int shipWithinDays(int[] weights, int days) 
    {
        int low=0;
        int high=0;

      for(int w:weights)
      {
         low=Math.max(w,low);
         high+=w;
      }
      int ans=high;
      while(low<=high)

      {
        int mid=low+(high-low)/2;
        if(can(weights, days, mid))
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
    private boolean can(int[] weights, int days,int cap)
    {
        int load=0;
        int dcnt=1;
        for(int w:weights)
        {
            if(load+w>cap)

            {
                dcnt++;
                load=0;

            }
            load+=w;
            if(dcnt>days) return false;
        }
        return true;
    }
}