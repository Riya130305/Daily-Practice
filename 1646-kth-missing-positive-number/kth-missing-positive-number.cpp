class Solution {
// public:
//     int fun(vector<int>& arr, int k, int mid){
//         int 
        
//     }    
public:
    int findKthPositive(vector<int>& arr, int k) {
        int ans=arr.size();

        int s=0;
        int e=arr.size()-1;

        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]-mid-1>=k){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans+k ;
    }
};