class Solution {
    public int minOperations(int[] nums, int k) {
        int sum= Arrays.stream(nums).sum();
        if(sum%k==0)
        return 0;
        if(sum<k)
        return sum;
        boolean n= true;
        int i=0;
        while(n)
        {
            sum-=1;
            i++;
            if(sum%k==0)
            {
                return i;
            }
        }
        return 0;
    }
}