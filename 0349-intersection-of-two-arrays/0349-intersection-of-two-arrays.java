class Solution {
    public int[] intersection(int[] nums1, int[] nums2) 
    {

       HashSet<Integer> ha=new HashSet<>();
               HashSet<Integer> ha2=new HashSet<>();
       for(int i : nums1)
       {
        ha.add(i);
       } 
       for(int i:nums2)
       {
        if(ha.contains(i))
        {
            ha2.add(i);

        }
       }
      int i=0;
      int a[]=new int[ha2.size()];
      for(int j:ha2)
      {
      a[i]=j;
      i++;
      }
      return a;
    }
}