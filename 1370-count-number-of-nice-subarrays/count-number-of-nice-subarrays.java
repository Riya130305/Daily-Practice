class Solution {
    // Slinding window(same as Binary subarray with sum)
    public int numberOfSubarrays(int[] nums, int k) {
        return fun(nums,k)-fun(nums,k-1);
    }
    public int fun(int[]nums,int k)
    {
        int i=0, j=0, sum=0, count=0;

        while(j<nums.length)
        {
            sum+=(nums[j]%2);//% by 2 is done to convert the in binary form to make the question again same as the Binary subarray with sum
            while(i<=j && sum>k)
            {
                sum-=(nums[i]%2);
                i++;
            }
            count+=(j-i+1);
            j++;
        }
        return count;
    }
}