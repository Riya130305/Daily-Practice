class Solution {
public:
    int fun(vector<int>& nums, int mid, int k){
        int sum=0;
        int count=1;

        for(int i=0;i<nums.size();i++){
            sum+=nums[i];
            if(sum>mid){
                count++;
                sum=0;
                sum+=nums[i];
            }
            // // else{
            // //     sum+=nums[i];
            // }


        }
        return count;
    }


public:
    int splitArray(vector<int>& nums, int k) {
        int l=*max_element(nums.begin(),nums.end());
        int r=accumulate(nums.begin(),nums.end(),0);
        int ans=0;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(k>=fun(nums,mid,k)){
                ans=mid;
                
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
};