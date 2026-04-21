class Solution {
    public void moveZeroes(int[] nums) {
        int j=0;
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
            else{
                c++;
            }
        }
        int idx=nums.length-1;
        while(c-->0){
            nums[idx--]=0;
        }
        return;
    }
}