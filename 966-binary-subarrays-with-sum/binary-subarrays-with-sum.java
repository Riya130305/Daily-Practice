class Solution {
    public int fun(int[] nums, int goal){
         int i=0,j=0,count=0,sum=0;
        while(j<nums.length){
            sum+=nums[j];
            while(i<=j && sum>goal){
                sum-=nums[i++];
            }
            count+=(j-i+1);
            j++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
       return fun(nums, goal)-fun(nums,goal-1);
    }
}