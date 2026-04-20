class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr= new int[2];
        
        HashMap<Integer,Integer> map= new HashMap<>();
        int j=0;
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i])){
                arr[0]=j;
                arr[1]=map.get(target-nums[i]);
            }
            else{
                map.put(nums[i],j);
            }
            j++;
        }
        return arr;
    }
}