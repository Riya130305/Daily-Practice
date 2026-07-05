class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        int n=nums.length;
        Arrays.fill(arr,-1);
        // checking in left diretion
        int l=0;
        int r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(nums[mid]==target){
                r=mid-1;
                arr[0]=mid;
                }
            
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        l=0;
        r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(nums[mid]==target){
                l=mid+1;
                arr[1]=mid;
                }
            
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return arr;
    }
}