class Solution {
    public int maxScore(int[] nums, int k) {
        if(nums.length==k)
        {
            int ans=Arrays.stream(nums).sum();
            return ans;
        }
        int lsum=0, rsum=0, max=0;
        for(int i=0;i<k;i++)
        {
            lsum+=nums[i];
        }
        max=Math.max(max,lsum+rsum);
        System.out.println("Max sum "+max);
        int rIdx=nums.length-1;
        for(int i=k-1;i>=0;i--)
        {
            lsum-=nums[i];
            System.out.println("lsum "+lsum);
            rsum+=nums[rIdx];
            System.out.println("rsum "+rsum);
            max=Math.max(max,lsum+rsum);
            System.out.println("-----max-----"+max);
            rIdx--;
        }
        return max;
    }
}