class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        int n=nums.length;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int com=target-nums[i];
            if(mp.containsKey(com))
            {
                return new int[]{mp.get(com),i};
            }
            mp.put(nums[i],i);
        }
        return  new int  []{};

    }
}