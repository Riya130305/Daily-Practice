class Solution {

    public int[] resultsArray(int[] nums, int k) {
        int sos = 0;
        int[] result = new int[nums.length-k+1];
        Arrays.fill(result, -1);
        int index = 0;
        for(int start=0, end = 0;end<nums.length;end++){
            if(end!=0 && nums[end]!= (nums[end-1]+1)){
                sos = end;
            }
            if(sos<start)
                sos = start;
            
            if(end+1>=k && (end-sos+1)==k){
                result[end-k+1] = nums[end];
            }

            if(end-start+1==k)
                start++;
                
        }
        return result;
    }
}