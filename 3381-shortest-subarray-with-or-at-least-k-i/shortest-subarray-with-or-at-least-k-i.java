class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int len=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int val=0;
            for(int j=i;j<n;j++){
                val=val|nums[j];
                if(val>=k){
                    len=Math.min(len,j-i+1);
                }
            }
        }
        if(len<Integer.MAX_VALUE)return len;
        return -1;
    }
}