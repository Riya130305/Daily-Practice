class Solution {
    public int[] runningSum(int[] nums) {
        int[] perfix=new int[nums.length];
        perfix[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            perfix[i]=perfix[i-1]+nums[i];
        } 
        return perfix;
    }
}