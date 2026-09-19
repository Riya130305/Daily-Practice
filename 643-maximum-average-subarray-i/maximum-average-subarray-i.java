class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg=0;
        double max=Integer.MIN_VALUE;
        int sum=0;

        int i=0,j=0;

        while(j<nums.length){
            sum+=nums[j];
            if(j-i+1 > k){
                sum-=nums[i];
                i++;
            }
            if(j-i+1 == k){
                avg = (double)sum/(j-i+1);
                max=Math.max(avg,max);
            }
            j++;
        }
        return max;
    }
}