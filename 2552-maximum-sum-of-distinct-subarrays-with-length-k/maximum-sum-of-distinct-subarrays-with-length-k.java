class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max=0,sum=0;
        int i=0,j=0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(j<nums.length){
            sum+=nums[j];
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);

            if(j-i+1>k){
                sum-=nums[i];
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0) {
                    map.remove(nums[i]);
                }
               
                i++;
            }
            if(j-i+1==k){
            if(map.size()==k){
                max=Math.max(max,sum);
            }}
            j++;
        }
        return max;
    }
}