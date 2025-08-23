class Solution {
    public int shipWithinDays(int[] weights, int days) 
    {
        int n=weights.length;
        int low=0;
        int high=0;
        for(int w:weights)
        {
            low=Math.max(low,w);
            high+=w;
        }
        int ans=high;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(canship(weights, days, mid))
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
    private boolean canship(int []weights,int days,int cap)

    {
        int daysc=1;
        int load=0;
        for(int i= 0;i<weights.length;i++)
        {
            if(load+weights[i]>cap)
            {
                daysc++;
                load=0;
            }
          
                load+=weights[i];
                if(daysc>days) return false;
           
         
        }
           return true;
}
}