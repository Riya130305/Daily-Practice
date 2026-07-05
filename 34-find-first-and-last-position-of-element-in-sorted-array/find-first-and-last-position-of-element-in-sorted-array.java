class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] arr = new int[2];
        int k=0;
        int c=-1;
        boolean count=true;
        Arrays.fill(arr,-1);
        for(int i=0;i<n;i++){
            int j=i;
            if(nums[i]==target && count){
                arr[0]=i;
                count=false;
            }
            while(j<n && nums[j]==target){
                c=j;
                j++;
            }
            
        }
        arr[1]=c;
        return arr;
    }
}