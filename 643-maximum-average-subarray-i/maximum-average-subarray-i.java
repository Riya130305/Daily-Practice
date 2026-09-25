class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans =Integer.MIN_VALUE, sum=0;
        int i=0, j=0;

        while(j<nums.length){
            sum+=nums[j];
            //System.out.println("sum+:"+sum);

            while(j-i+1>k){
                sum-=nums[i];
                //System.out.println("sum-:"+sum);
                i++;

            }

            if(j-i+1==k){
                double val =sum/k;
                ans=Math.max(ans,val);
               // System.out.println("ans:"+ans);
            }
            System.out.println();
            j++;
        }
        return ans;
    }
}