class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] ans = new int[n];
        if(n==1)return ans;
        int[] l= new int[n];
        int[] r=new int[n];
        l[0]=0;
        r[n-1]=0;
        l[1]=nums[0];
        r[n-2]=nums[n-1];
        for(int i=2;i<n;i++)
        {
            l[i]=l[i-1]+nums[i-1];
        }
        for(int i=n-3;i>=0;i--)
        {
            r[i]=r[i+1]+nums[i+1];
        }
        for(int i=0;i<n;i++)
        {
            ans[i]=Math.abs(l[i]-r[i]);
        }
        return ans ;
    }
}