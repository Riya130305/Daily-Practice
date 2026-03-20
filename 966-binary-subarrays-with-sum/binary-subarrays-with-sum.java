class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return fun(nums,goal)-fun(nums,goal-1);
    }
    public int fun(int[]nums, int goal)
    {
               int i=0, j=0, sum=0, count=0;

        while(j<nums.length)
        {
            sum+=nums[j];
            while( i<=j && sum>goal)
            {
                sum-=nums[i];
                i++;
            }
            count+=(j-i+1);//to get the number of subarray with particular number incresing
            j++; 

        }
        return count;
    }
}