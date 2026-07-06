class Solution {
    public int findMin(int[] nums) {
        int s=0;
        int n=nums.length;
        int e=n-1;
        int ans=0;

        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]>=nums[e]){
                s=mid+1;
                ans = mid;
            }
            else {
                e=mid;
                // ans=mid;
            }
        }
        return nums[0]<nums[ans] ? nums[0]:nums[ans];
    }
}