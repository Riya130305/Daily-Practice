class Solution {
    public int minOperations(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-2;i++)
        {
            int loop=3;
            if(nums[i]==0)
            {
                count++;
                int j=i;
                while(loop-->0)
                {
                    nums[j]=1-nums[j];
                    j++;
                }
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            return -1;
        }
        return count;
    }
}