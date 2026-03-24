class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
             int sum=(nums[i]+i);
            System.out.println("sum** "+(i+nums[i]));
            if(i>max)
            {
                return false;
            }
            max=Math.max(sum,max);
            System.out.println(max);

        }
        return true;
    }
}