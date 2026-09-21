class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0,min=Integer.MAX_VALUE,sum=0;

        while(j<nums.length){
            sum+=nums[j];
            while(sum>=target){
                sum-=nums[i];
                min= Math.min(min,j-i+1);
                i++;
            }
            j++;
        }
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }
}