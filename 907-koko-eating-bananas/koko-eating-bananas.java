class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int e=Arrays.stream(arr).max().getAsInt();
        int s=1;
        int ans=0;

        while(s<=e){
            int mid=s+(e-s)/2;
            if(fun(arr,h,mid)<=h){
                // ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return s;
    }
    public int fun(int[] arr, int h, int mid){
        int sum=0;
       
        for(int i=0;i<arr.length;i++){
            sum+=Math.ceil((double)arr[i]/mid);
        }
        return sum;
    } 
}