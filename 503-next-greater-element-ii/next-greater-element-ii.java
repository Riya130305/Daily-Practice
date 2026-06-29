class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
       int[] arr = new int[n];
       Arrays.fill(arr,-1);
       int k=0;
       for(int i=0;i<n;i++)
       {
            for(int j=i; j<2*n ;j++)
            {
                if(nums[i]<nums[j%n]){
                    arr[i]=nums[j%n];
                    break;
                }
            }
       }
       return arr;
    }
}