class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0, j=0, max=0, len=0;
        int zeroC=0;
    
        while(j<nums.length)
        {
            if(nums[j]==0)
            {
                zeroC++;
            }
            while(zeroC>k)
            {
                
                if(nums[i]==0)
                {
                    zeroC--;
                }
                i++;
            }
            if(k>=zeroC)
            {
            len=j-i+1;
            max=Math.max(max,len);
            }
            j++;
        }
        return max;
    }
}