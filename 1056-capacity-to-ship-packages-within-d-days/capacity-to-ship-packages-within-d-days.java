class Solution {
    public int shipWithinDays(int[] arr, int k) {
        int l=Arrays.stream(arr).max().getAsInt();
        int r= Arrays.stream(arr).sum();
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
    public boolean fun(int mid, int arr[], int k){
        int d=1;
        int sum=0;

        for(int i=0;i<arr.length;i++){
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
}