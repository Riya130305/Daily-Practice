class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> set= new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            int left=i+1;
            int rigth=nums.length-1;

            while(left<rigth)
            {
                int sum=nums[left]+nums[rigth]+nums[i];
                if(sum==0)
                {
                    set.add(Arrays.asList(nums[i],nums[left],nums[rigth]));
                    left++;
                    rigth--;
                }
                else if(sum<0)
                {
                    left++;
                }
                else
                {
                    rigth--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}