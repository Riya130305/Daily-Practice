class Solution {
public:
    int shipWithinDays(vector<int>& arr, int k) {
        int l= *max_element(arr.begin(),arr.end());
        int r= accumulate(arr.begin(), arr.end(),0);
        int ans=-1;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(fun(mid,arr,k)){
                r=mid-1;
                ans =mid;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }

    bool fun(int mid,vector<int> &arr, int k){
          int d=1;
        int sum=0;

        for(int i=0;i<arr.size();i++){
            if(sum+arr[i]<=mid){
                sum+=arr[i];
            }
            else{
                d++;
                sum=arr[i];
            }
        }
        return d<=k;
    }
};

