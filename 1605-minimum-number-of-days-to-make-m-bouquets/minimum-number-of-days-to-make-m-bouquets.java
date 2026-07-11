class Solution {
    public int minDays(int[] arr, int m, int k) {
        int l=1;
        int r=Arrays.stream(arr).max().getAsInt();
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(fun(arr,mid,k,m)){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }

    public boolean fun(int[]arr,int mid,int k,int m){
        int count=0;
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                count++;
               
            }else{
                ans=ans+(count/k);
                count=0;
            }
        }
        ans=ans+(count/k);
        return ans>=m;
    }
}